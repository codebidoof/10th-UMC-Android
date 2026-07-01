import com.android.build.api.dsl.ApplicationExtension
import java.util.Properties
import kotlin.apply

plugins {
    id("mky.android.library")
    id("mky.android.hilt")
    alias(libs.plugins.kotlin.serialization)
}

val localProperties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

android {
    namespace = "kr.co.mky.network"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        val baseUrl = localProperties.getProperty("BASE_URL")
            ?: throw GradleException(
                """
                BASE_URL이 local.properties에 정의되지 않았습니다
                local.properties 파일에 BASE_URL을 추가하세요
                """.trimIndent()
            )

        buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    // domain 모듈
    implementation(project(":core:domain"))

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // OkHttp
    implementation(libs.okHttp)
    implementation(libs.okHttp.logging.interceptor)

    // kotlinx-serialization
    implementation(libs.kotlinx.serialization.json)

    // timber
    implementation(libs.timber)
}