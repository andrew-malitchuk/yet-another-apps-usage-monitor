import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(libs.detekt.gradle.plugin)
    implementation(libs.kotlinter.gradle)
    implementation(libs.lint.checks)
    implementation(libs.lint.api)
}

gradlePlugin {
    plugins {
        //region Android
        register("androidApplication") {
            id = "yaaum.convention.application"
            implementationClass =
                "dev.yaaum.convention.conventionplugin.android.AndroidApplicationConventionPlugin"
        }
        register("androidComposeApplication") {
            id = "yaaum.convention.compose.application"
            implementationClass =
                "dev.yaaum.convention.conventionplugin.android.AndroidApplicationComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "yaaum.convention.feature"
            implementationClass =
                "dev.yaaum.convention.conventionplugin.android.AndroidFeatureConventionPlugin"
        }
        register("androidComposeFeature") {
            id = "yaaum.convention.compose.feature"
            implementationClass =
                "dev.yaaum.convention.conventionplugin.android.AndroidFeatureComposeConventionPlugin"
        }
        register("androidTest") {
            id = "yaaum.convention.test.android"
            implementationClass =
                "dev.yaaum.convention.conventionplugin.android.AndroidTestConventionPlugin"
        }
        //endregion Android
        //region Kotlin
        register("kotlinLibrary") {
            id = "yaaum.convention.library"
            implementationClass =
                "dev.yaaum.convention.conventionplugin.kotlin.KotlinLibraryConventionPlugin"
        }
        register("kotlinTest") {
            id = "yaaum.convention.test.kotlin"
            implementationClass =
                "dev.yaaum.convention.conventionplugin.kotlin.KotlinTestConventionPlugin"
        }
        //endregion Kotlin
        //region Common
        register("commonDetekt") {
            id = "yaaum.convention.common.detekt"
            implementationClass =
                "dev.yaaum.convention.conventionplugin.common.DetektConventionPlugin"
        }
        register("commonKtlint") {
            id = "yaaum.convention.common.ktlint"
            implementationClass =
                "dev.yaaum.convention.conventionplugin.common.KtlintConventionPlugin"
        }
        //endregion Common
    }
}

// Necessary for context receiver
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }
}