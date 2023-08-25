@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.common.lint")
}

android {
    namespace = "dev.yaaum.domain.impl"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
}