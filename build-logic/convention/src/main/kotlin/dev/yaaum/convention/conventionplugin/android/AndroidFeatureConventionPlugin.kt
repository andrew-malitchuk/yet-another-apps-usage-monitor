package dev.yaaum.convention.conventionplugin.android

import dev.yaaum.convention.config.ProjectConfig
import dev.yaaum.convention.ext.implementDependency
import dev.yaaum.convention.ext.kotlinOptions
import dev.yaaum.convention.ext.lib
import dev.yaaum.convention.ext.libs
import dev.yaaum.convention.ext.plugins
import dev.yaaum.convention.ext.unaryPlus
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Convention plugin for feature-module
 *
 * @see AndroidFeatureComposeConventionPlugin
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        plugins {
            +"com.android.library"
            +"org.jetbrains.kotlin.android"
        }

        lib {
            defaultConfig {
                compileSdk = ProjectConfig.SDK.COMPILE_SDK
                minSdk = ProjectConfig.SDK.MIN_SDK
                // TODO: Fix it!
                @Suppress("DEPRECATION")
                targetSdk = ProjectConfig.SDK.TARGET_SDK
            }
            compileOptions {
                sourceCompatibility = ProjectConfig.JAVA_VERSION
                targetCompatibility = ProjectConfig.JAVA_VERSION
            }
            kotlinOptions {
                jvmTarget = ProjectConfig.KOTLIN_VERSION
            }
        }
        with(libs) {
            dependencies {
                implementDependency("squareup.logcat")
                implementDependency("kotlinx.coroutines.core")
            }
        }
        // Necessary for context receiver
        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
            }
        }
    }

}

