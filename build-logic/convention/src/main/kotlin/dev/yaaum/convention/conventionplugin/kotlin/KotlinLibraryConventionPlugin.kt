package dev.yaaum.convention.conventionplugin.kotlin

import dev.yaaum.convention.ext.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 * Convention plugin for vanilla Kotlin module (without Android stuff)
 */
@Suppress("unused")
class KotlinLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        plugins {

        }
    }

}