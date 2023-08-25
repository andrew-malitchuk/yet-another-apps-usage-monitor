package dev.yaaum.convention.conventionplugin.common


import dev.yaaum.convention.ext.detekt
import dev.yaaum.convention.ext.plugins
import dev.yaaum.convention.ext.unaryPlus
import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 * Contains configuration for detekt
 */
@Suppress("unused")
class DetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins {
            +"io.gitlab.arturbosch.detekt"
        }
        detekt {
            buildUponDefaultConfig = true
            allRules = true
            config.setFrom("${rootProject.rootDir}$DETEKT_CONFIG_PATH")
        }
    }

    companion object {
        /**
         * Relative path for YML file with configuration
         */
        const val DETEKT_CONFIG_PATH = "/config/detekt/detekt.yml"
    }
}