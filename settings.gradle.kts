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

// TODO: rename
//region Common
include(":common")
include(":common:core")
include(":common:konsist")
//endregion Common

//region Data
include(":data")
include(":data:core")
include(":data:repository:core")
include(":data:repository:timeusage")
include(":data:repository:timeusage:impl")
include(":data:repository:configuration")
include(":data:repository:configuration:impl")
include(":data:repository:applications")
include(":data:repository:applications:impl")
include(":data:source:system")
include(":data:source:system:core")
include(":data:source:system:timeusage")
include(":data:source:system:timeusage:impl")
include(":data:source:datastore")
include(":data:source:datastore:core")
include(":data:source:datastore:configuration")
include(":data:source:datastore:configuration:impl")
include(":data:source:system:applications")
include(":data:source:system:applications:impl")
include(":data:source:database")
include(":data:source:database:core")
include(":data:source:database:applications")
include(":data:source:database:applications:impl")
//region Data

//region Domain
include(":domain")
include(":domain:core")
include(":domain:timeusage")
include(":domain:timeusage:impl")
include(":domain:configuration")
include(":domain:configuration:impl")
include(":domain:applications")
include(":domain:applications:impl")
//endregion Domain

//region Presentation
include(":presentation")
include(":presentation:core")
include(":presentation:core:localisation")
include(":presentation:core:models")
include(":presentation:core:navigation")
include(":presentation:core:platform")
include(":presentation:core:ui")
include(":presentation:core:analytics")
include(":presentation:core:analytics:core")
include(":presentation:core:analytics:logger")
include(":presentation:core:analytics:logger:impl")
include(":presentation:core:analytics:publisher")
include(":presentation:core:analytics:publisher:impl")
include(":presentation:core:analytics:subscriber")
include(":presentation:core:analytics:subscriber:impl")
include(":presentation:core:analytics:subscriber:impl:firebase")
include(":presentation:core:analytics:subscriber:impl:local")
//region Feature
include(":presentation:feature")
include(":presentation:feature:host")
include(":presentation:feature:main")
include(":presentation:feature:onboarding")
include(":presentation:feature:settings")
include(":presentation:feature:applications")
include(":presentation:feature:statistics")
//endregion Feature
//endregion Presentation