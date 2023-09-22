plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.koin")
    id("kotlinx-serialization")
}

android {
    namespace = "dev.yaaum.data.source.datastore.configuration.impl"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.kotlinx.serialization.json)
    implementation(project(":data:source:datastore:configuration"))
    implementation(project(":data:source:datastore:core"))
    implementation(libs.datastore)
}