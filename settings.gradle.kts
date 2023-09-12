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
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "YAAUM"

include(":app")

//region Common
include(":common")
include(":common:core")
//endregion Common

//region Domain
include(":domain")
include(":domain:core")
include(":domain:timeusage")
include(":domain:timeusage:impl")
//endregion Domain

//region Data
include(":data")
include(":data:core")
include(":data:repository:core")
include(":data:repository:timeusage")
include(":data:repository:timeusage:impl")
include(":data:system")
include(":data:system:core")
include(":data:system:timeusage")
include(":data:system:timeusage:impl")
//region Data

//region Presentation
include(":presentation")
include(":presentation:core")
include(":presentation:core:localisation")
include(":presentation:core:navigation")
include(":presentation:core:ui")
//region Feature
include(":presentation:feature")
include(":presentation:feature:main")
include(":presentation:feature:host")
include(":presentation:feature:onboarding")
include(":presentation:feature:settings")
//endregion Feature
//endregion Presentation