package dev.yaaum.convention.conventionplugin.android

import com.android.build.api.dsl.ApplicationExtension
import dev.yaaum.convention.config.ProjectConfig
import dev.yaaum.convention.config.VersionConfig
import dev.yaaum.convention.ext.app
import dev.yaaum.convention.ext.id
import dev.yaaum.convention.ext.implementDependency
import dev.yaaum.convention.ext.kotlinOptions
import dev.yaaum.convention.ext.libs
import dev.yaaum.convention.ext.plugins
import dev.yaaum.convention.ext.unaryPlus
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {

        // XXX:
//            with(pluginManager) {
//                apply("com.android.application")
//                apply("org.jetbrains.kotlin.android")
//            }
        plugins {
            +"com.android.application"
            +"org.jetbrains.kotlin.android"
        }

        app {
            defaultConfig {
                applicationId = ProjectConfig.APPLICATION_ID
                compileSdk = ProjectConfig.SDK.COMPILE_SDK
                minSdk = ProjectConfig.SDK.MIN_SDK
                targetSdk = ProjectConfig.SDK.TARGET_SDK

                versionCode = VersionConfig.VERSION_CODE
                versionName = VersionConfig.VERSION_NAME
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
                implementDependency("core.ktx")
            }
        }
    }

}