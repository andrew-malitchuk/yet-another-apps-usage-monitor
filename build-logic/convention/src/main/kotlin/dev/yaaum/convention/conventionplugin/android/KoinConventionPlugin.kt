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

/**
 * Convention plugin for Koin DI
 */
class KoinConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(libs) {
            dependencies {
                implementDependency("koin.core")
                implementDependency("koin.android")
                implementDependency("koin.compose")
            }
        }
    }

}