plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.data.source.datastore.core"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}