import java.util.Properties

plugins {
    id("mky.android.library")
    id("mky.android.compose")
    id("mky.android.hilt")
    alias(libs.plugins.kotlin.serialization)
}

val localProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { load(it) }
    }
}

android {
    namespace = "kr.co.mky.impl"
    compileSdk = 36
}

dependencies {
    implementation(project(":feature:bag:api"))

    // core 모듈
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))

    // compose
    implementation(libs.compose.activity)
    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.compose)

    // timber
    implementation(libs.timber)

    // test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}