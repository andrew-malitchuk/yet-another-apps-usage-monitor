plugins {
    id("yaaum.convention.compose.application")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    alias(libs.plugins.ksp)
}

android {
    namespace = "dev.yaaum.app"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    implementation(project(":presentation:feature:host"))
    implementation(project(":presentation:feature:onboarding"))
}