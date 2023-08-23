import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    dependencies{
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.0")
    }
}

plugins {
    `kotlin-dsl`
}

group = "dev.yaaum.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.detekt.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "yaaum.convention.application"
            implementationClass = "dev.yaaum.convention.conventionplugin.android.AndroidApplicationConventionPlugin"
        }
        register("androidComposeApplication") {
            id = "yaaum.convention.compose.application"
            implementationClass = "dev.yaaum.convention.conventionplugin.android.AndroidApplicationComposeConventionPlugin"
        }
        register("commonDetekt") {
            id = "yaaum.convention.common.detekt"
            implementationClass = "dev.yaaum.convention.conventionplugin.common.DetektConventionPlugin"
        }
    }
}