@file:Suppress("SpellCheckingInspection")

package dev.yaaum.convention.conventionplugin.android

import dev.yaaum.convention.ext.app
import dev.yaaum.convention.ext.implementDependency
import dev.yaaum.convention.ext.libs
import dev.yaaum.convention.ext.plugins
import dev.yaaum.convention.ext.unaryPlus
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

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
        app {
            buildFeatures.compose = true
            composeOptions {
                kotlinCompilerExtensionVersion = libs.findVersion("androidxComposeCompiler").get().toString()
            }
        }
        with(libs) {
            dependencies {
                implementDependency("material3")
                implementDependency("ui.tooling")
                implementDependency("ui.tooling.preview")
                implementDependency("activity.compose")
                implementDependency("lifecycle.viewmodel.compose")
                implementDependency("compose.runtime")
                implementDependency("accompanist.systemuicontroller")
            }
        }
    }

}