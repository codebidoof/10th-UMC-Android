plugins {
    id("mky.android.library")
    id("mky.android.hilt")
    alias(libs.plugins.ksp)
}

android {
    namespace = "kr.co.mky.database"
}

dependencies {
    implementation(libs.androidx.core.ktx)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

}