@file:Suppress("SpellCheckingInspection")

package dev.yaaum.convention.conventionplugin.android

import dev.yaaum.convention.ext.plugins
import dev.yaaum.convention.ext.unaryPlus
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * AndroidApplicationComposeConventionPlugin = AndroidApplicationConventionPlugin + Compose
 *
 * @see AndroidApplicationConventionPlugin
 */
@Suppress("SpellCheckingInspection")
class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins {
            +"yaaum.convention.application"
        }
    }

}