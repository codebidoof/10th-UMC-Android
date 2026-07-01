plugins {
    id("mky.android.library")
    id("mky.android.compose")
    id("mky.android.hilt")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "kr.co.mky.impl"
    compileSdk = 36
}

dependencies {
    implementation(project(":feature:profile:api"))

    // core 모듈
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))

    // compose
    implementation(libs.compose.activity)
    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.compose)

    // TODO: nav3

    // test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}