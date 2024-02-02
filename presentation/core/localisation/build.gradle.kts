plugins {
    id("yaaum.convention.compose.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.presentation.core.localisation"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
}