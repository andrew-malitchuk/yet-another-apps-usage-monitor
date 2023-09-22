plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.koin")
}

android {
    namespace = "dev.yaaum.data.repository.timeusage.impl"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    implementation(project(":data:source:system:timeusage"))
    implementation(project(":data:source:system:core"))
    implementation(project(":data:source:datastore:configuration"))
    implementation(project(":data:repository:timeusage"))
    implementation(project(":data:repository:core"))
}