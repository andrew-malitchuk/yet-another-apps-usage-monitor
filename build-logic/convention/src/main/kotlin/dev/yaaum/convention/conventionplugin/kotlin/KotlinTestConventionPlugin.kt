package dev.yaaum.convention.conventionplugin.kotlin

import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class KotlinTestConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {

            }
        }
    }

}