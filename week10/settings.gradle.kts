pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Nike"
include(":app")
include(":core:domain")
include(":core:network")
include(":core:data")
include(":core:database")
include(":core:designsystem")
include(":feature:home")
include(":feature:buy")
include(":feature:bag")
include(":feature:profile")
include(":feature:wishlist")
include(":build-logic")
