plugins {
    id("yaaum.convention.compose.application")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.koin")
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.yaaum.app"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    implementation(libs.bundles.arrow)
    ksp(libs.arrow.optics.ksp.plugin)

    implementation(project(":common:core"))

    implementation(project(":presentation:feature:host"))
    implementation(project(":presentation:feature:main"))
    implementation(project(":presentation:feature:onboarding"))
    implementation(project(":presentation:feature:settings"))
    implementation(project(":presentation:core:navigation"))
    implementation(project(":data:source:system:timeusage"))
    implementation(project(":data:source:system:timeusage:impl"))
    implementation(project(":data:source:datastore:configuration"))
    implementation(project(":data:source:datastore:configuration:impl"))
    implementation(project(":data:repository:timeusage:impl"))
    implementation(project(":data:repository:timeusage"))
    implementation(project(":data:repository:configuration:impl"))
    implementation(project(":data:repository:configuration"))

    implementation(project(":domain:core"))
    implementation(project(":domain:timeusage"))
    implementation(project(":domain:timeusage:impl"))
    implementation(project(":domain:configuration"))
    implementation(project(":domain:configuration:impl"))
}

// Necessary for context receiver
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }
}