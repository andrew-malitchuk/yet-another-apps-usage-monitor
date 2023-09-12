plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.koin")
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.yaaum.data.repository.timeusage.impl"
}

dependencies{
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.arrow.core)
    implementation(libs.arrow.fx.coroutines)
    implementation(libs.arrow.optics)
    ksp(libs.arrow.optics.ksp.plugin)
    implementation(project(":data:system:timeusage"))
    implementation(project(":data:system:core"))
    implementation(project(":data:repository:timeusage"))
    implementation(project(":data:repository:core"))
}

// Necessary for context receiver
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }
}