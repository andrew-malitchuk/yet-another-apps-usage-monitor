package dev.yaaum.convention.conventionplugin.common

import dev.yaaum.convention.ext.app
import dev.yaaum.convention.ext.unaryMinus
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Configuration for Android Lint
 */
@Suppress("unused", "UnstableApiUsage")
class LintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        app {
            lint {
                -"TypographyFractions"
                checkDependencies = true
                abortOnError = true
                ignoreWarnings = false
            }
        }
    }

}