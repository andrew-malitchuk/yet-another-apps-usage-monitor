package dev.yaaum.convention.conventionplugin.kotlin

import dev.yaaum.convention.ext.implementDependency
import dev.yaaum.convention.ext.libs
import dev.yaaum.convention.ext.plugins
import dev.yaaum.convention.ext.unaryPlus
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


/**
 * Convention plugin for vanilla Kotlin module (without Android stuff)
 */
@Suppress("unused")
class KotlinLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        plugins {
            +"org.jetbrains.kotlin.android"
        }
        with(libs) {
            dependencies {
                implementDependency("stream.log.android")
            }
        }
    }

}