import com.android.build.api.dsl.ApplicationExtension
import java.util.Properties

plugins {
    id("mky.android.application")
    id("mky.android.compose")
    id("mky.android.hilt")
}

val localProperties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

configure<ApplicationExtension> {
    namespace = "kr.co.umc.nike"

    defaultConfig {
        applicationId = "kr.co.umc.nike"
        versionCode = 1
        versionName = "1.0"

        buildConfigField(
            "String",
            "BASE_URL",
            "\"${localProperties["BASE_URL"]}\""
        )
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
        compose = true
    }
}

dependencies {

    // feature 모듈
    implementation(project(":feature:home:api"))
    implementation(project(":feature:home:impl"))
    implementation(project(":feature:buy:api"))
    implementation(project(":feature:buy:impl"))
    implementation(project(":feature:wishlist:api"))
    implementation(project(":feature:wishlist:impl"))
    implementation(project(":feature:bag:api"))
    implementation(project(":feature:bag:impl"))
    implementation(project(":feature:profile:api"))
    implementation(project(":feature:profile:impl"))

    // core 모듈
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:database"))

    // 필수 의존성
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Navigation
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    // Timber
    implementation(libs.timber)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // OkHttp
    implementation(libs.okHttp)
    implementation(libs.okHttp.logging.interceptor)

    // Coil
    implementation(libs.coil)
    implementation(libs.coil.network.okhttp)
    implementation(libs.coil.compose)

    // Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.activity)
    debugImplementation(libs.compose.ui.tooling)

    // Compose Navigation & Hilt
    implementation(libs.hilt.navigation.compose)
    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.lifecycle.viewmodel.compose)
}