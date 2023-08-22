plugins {
    id("yaaum.convention.application")
}

android {
    namespace = "dev.yaaum.app"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
}