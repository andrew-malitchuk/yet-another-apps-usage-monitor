package dev.yaaum.convention.conventionplugin.android

import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply{
                apply("yaaum.convention.application")
            }

        }
    }
}