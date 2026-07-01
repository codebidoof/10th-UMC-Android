plugins {
    id("mky.android.library")
    id("mky.android.compose")
}

android {
    namespace = "kr.co.mky.designsystem"
}

dependencies {
    // Compose 의존성은 AndroidComposeConventionPlugin에서 자동 추가됨

    // android 의존성
    implementation(libs.androidx.core.ktx)
    implementation(libs.compose.material3)
}