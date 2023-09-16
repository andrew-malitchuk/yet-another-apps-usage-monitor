plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.data.source.system.timeusage"
}

dependencies{
    implementation(libs.kotlinx.coroutines.core)
    implementation(project(":data:source:system:core"))
}