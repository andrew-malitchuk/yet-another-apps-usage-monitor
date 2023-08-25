@file:Suppress("UnstableApiUsage")
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
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

rootProject.name = "YAAUM"
include(":app")

//region Domain
include(":domain")
include(":domain:impl")
include(":domain:core")
//endregion Domain

include(":data")
include(":data:core")
include(":data:repository:impl")
include(":data:repository")
