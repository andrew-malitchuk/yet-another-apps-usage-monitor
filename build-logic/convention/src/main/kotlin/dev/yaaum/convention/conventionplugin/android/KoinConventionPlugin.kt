package dev.yaaum.convention.conventionplugin.android

import dev.yaaum.convention.ext.implementDependency
import dev.yaaum.convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Convention plugin for Koin DI
 */
@Suppress("unused")
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