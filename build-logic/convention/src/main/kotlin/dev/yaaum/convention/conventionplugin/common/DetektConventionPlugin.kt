package dev.yaaum.convention.conventionplugin.common

import dev.yaaum.convention.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project


import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.kotlin.dsl.getByType

class DetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
            }
            extensions.getByType<DetektExtension>().apply {
                buildUponDefaultConfig = true
                allRules = true
                config.setFrom("${rootProject.rootDir}$DETEKT_CONFIG_PATH")
            }
        }
    }

    companion object {
        const val DETEKT_CONFIG_PATH = "/config/detekt/detekt.yml"
    }
}