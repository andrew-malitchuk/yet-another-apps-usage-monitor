plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.koin")
}

android {
    namespace = "dev.yaaum.data.source.system.applications.impl"
}

dependencies{
    implementation(libs.kotlinx.coroutines.core)
    implementation(project(":data:source:system:applications"))
    implementation(project(":data:source:system:core"))
}