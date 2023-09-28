plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.data.repository.configuration"
}

dependencies{
    implementation(libs.kotlinx.coroutines.core)
    implementation(project(":data:repository:core"))
    implementation(project(":data:source:datastore:configuration"))
    implementation(project(":data:source:datastore:core"))
    implementation(project(":data:core"))
}