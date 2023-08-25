package dev.yaaum.convention.conventionplugin.android

import dev.yaaum.convention.ext.plugins
import dev.yaaum.convention.ext.unaryPlus
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * AndroidFeatureComposeConventionPlugin = AndroidFeatureConventionPlugin + Compose
 *
 * @see AndroidFeatureConventionPlugin
 */
class AndroidFeatureComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        plugins {
            +"yaaum.convention.feature"
        }
    }

}