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

    implementation(project(":presentation:feature:host"))
    implementation(project(":presentation:feature:onboarding"))
    implementation(project(":presentation:feature:settings"))
    implementation(project(":presentation:core:navigation"))
    // XX
    implementation(project(":data:system:timeusage"))
    implementation(project(":data:system:timeusage:impl"))
}

// Necessary for context receiver
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }
}