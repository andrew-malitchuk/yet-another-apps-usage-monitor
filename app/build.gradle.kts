plugins {
//    id("yaaum.convention.application")
    id("yaaum.convention.compose.application")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.app"
}

dependencies {
//    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
}