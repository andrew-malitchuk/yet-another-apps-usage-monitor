plugins {
    id("yaaum.convention.application")
    id("yaaum.convention.common.detekt")
}

android {
    namespace = "dev.yaaum.app"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
}