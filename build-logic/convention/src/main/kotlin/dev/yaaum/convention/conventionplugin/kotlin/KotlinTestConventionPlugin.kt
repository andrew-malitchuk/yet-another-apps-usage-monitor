package dev.yaaum.convention.conventionplugin.kotlin

import dev.yaaum.convention.ext.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Convention plugin for unit-test (without Android stuff)
 */
@Suppress("unused")
class KotlinTestConventionPlugin : Plugin<Project> {

    override fun apply(target: Project)= with(target) {
        plugins {

        }
    }

}