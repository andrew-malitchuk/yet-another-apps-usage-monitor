plugins {
    `kotlin-dsl`
}

group = "dev.yaaum.buildlogic"

java {
    @Suppress("UnstableApiUsage")
    sourceCompatibility = JavaVersion.VERSION_24
    @Suppress("UnstableApiUsage")
    targetCompatibility = JavaVersion.VERSION_24
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {

    }
}