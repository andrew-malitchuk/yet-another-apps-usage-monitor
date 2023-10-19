plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.data.source.database.applications"
}

dependencies{
    implementation(libs.kotlinx.coroutines.core)
    implementation(project(":data:source:database:core"))
    implementation(project(":data:core"))
}