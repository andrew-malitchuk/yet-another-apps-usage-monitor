plugins {
    id("yaaum.convention.feature")
    id("yaaum.convention.common.detekt")
    id("yaaum.convention.common.ktlint")
    id("yaaum.convention.test.kotlin")
}

android {
    namespace = "dev.yaaum.core.konsist"
}


dependencies{
    testImplementation(libs.konsist)

    testImplementation(project(":data:repository:core"))
    testImplementation(project(":data:repository:timeusage"))
    testImplementation(project(":data:repository:timeusage:impl"))

    testImplementation(project(":domain:core"))
    testImplementation(project(":domain:timeusage"))
    testImplementation(project(":domain:timeusage:impl"))
}