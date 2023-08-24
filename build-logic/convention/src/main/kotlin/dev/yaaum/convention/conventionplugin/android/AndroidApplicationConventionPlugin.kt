package dev.yaaum.convention.conventionplugin.android

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import dev.yaaum.convention.config.ProjectConfig
import dev.yaaum.convention.config.VersionConfig
import dev.yaaum.convention.ext.implementDependency
import dev.yaaum.convention.ext.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

@Suppress("unused")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
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
            extensions.getByType<VersionCatalogsExtension>().named("libs").apply {
                dependencies {
                    implementDependency {
                        "core.ktx"
                    }
                }
            }
        }
    }

}