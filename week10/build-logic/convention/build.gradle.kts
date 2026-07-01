import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "kr.co.umc.nike.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "mky.android.application"
            implementationClass = "kr.co.mky.convention.AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "mky.android.library"
            implementationClass = "kr.co.mky.convention.AndroidLibraryConventionPlugin"
        }

        register("androidCompose") {
            id = "mky.android.compose"
            implementationClass = "kr.co.mky.convention.AndroidComposeConventionPlugin"
        }

        register("androidHilt") {
            id = "mky.android.hilt"
            implementationClass = "kr.co.mky.convention.AndroidHiltConventionPlugin"
        }

        register("kotlinLibrary") {
            id = "mky.kotlin.library"
            implementationClass = "kr.co.mky.convention.KotlinLibraryConventionPlugin"
        }
    }
}
