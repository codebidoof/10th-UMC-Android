plugins {
    id("mky.android.library")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "kr.co.mky.api"
    compileSdk = 36
}

dependencies {
    // TODO: NAV3 추가
    //
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.core.ktx)

    // test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}