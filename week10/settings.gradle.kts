pluginManagement {
    includeBuild("build-logic")
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
include(":feature:home:api")
include(":feature:buy:api")
include(":feature:bag:api")
include(":feature:wishlist:api")
include(":feature:profile:api")
include(":feature:bag:impl")
include(":feature:buy:impl")
include(":feature:home:impl")
include(":feature:profile:impl")
include(":feature:wishlist:impl")
