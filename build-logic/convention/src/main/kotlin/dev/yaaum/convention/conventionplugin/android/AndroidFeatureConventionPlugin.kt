package dev.yaaum.convention.conventionplugin.android

import dev.yaaum.convention.ext.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Convention plugin for feature-module
 *
 * @see AndroidFeatureComposeConventionPlugin
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        plugins {

        }
    }

}