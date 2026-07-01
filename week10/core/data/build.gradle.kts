plugins {
    id("mky.android.library")
    id("mky.android.hilt")
}

android {
    namespace = "kr.co.mky.data"
}

dependencies {
    // 다른 core 모듈 의존성
    implementation(project(":core:domain"))
    implementation(project(":core:network"))
    implementation(project(":core:database"))

    // android 의존성
    implementation(libs.androidx.core.ktx)

    // timber
    implementation(libs.timber)
}