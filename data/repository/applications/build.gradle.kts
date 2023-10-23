plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.data.repository.applications"
}

dependencies{
    implementation(libs.kotlinx.coroutines.core)

    implementation(project(":data:source:system:core"))
    implementation(project(":data:source:database:core"))
    implementation(project(":data:repository:core"))
    implementation(project(":data:core"))
    implementation(project(":data:source:system:applications"))
    implementation(project(":data:source:database:applications"))
}