package dev.yaaum.convention.conventionplugin.common

import dev.yaaum.convention.ext.ktlint
import dev.yaaum.convention.ext.plugins
import dev.yaaum.convention.ext.unaryPlus
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Configuration for ktlint
 */
@Suppress("unused")
class KtlintConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        plugins {
            +"org.jmailen.kotlinter"
        }
        ktlint {

        }
    }

}