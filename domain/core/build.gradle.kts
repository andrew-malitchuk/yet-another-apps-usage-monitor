plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
}

android {
    namespace = "dev.yaaum.domain.core"
}

dependencies {
    implementation(project(":common:core"))
    implementation(project(":data:core"))
}