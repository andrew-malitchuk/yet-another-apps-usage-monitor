package dev.yaaum.convention.conventionplugin.kotlin

import dev.yaaum.convention.ext.implementDependency
import dev.yaaum.convention.ext.libs
import dev.yaaum.convention.ext.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Convention plugin for unit-test (without Android stuff)
 */
@Suppress("unused")
class KotlinTestConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        plugins {

        }
        with(libs) {
            dependencies {
                implementDependency("junit")
                implementDependency("mockito.core")
                implementDependency("mockito.kotlin")
            }
        }
    }

}