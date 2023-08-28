package dev.yaaum.convention.conventionplugin.android

import dev.yaaum.convention.ext.implementDependency
import dev.yaaum.convention.ext.lib
import dev.yaaum.convention.ext.libs
import dev.yaaum.convention.ext.plugins
import dev.yaaum.convention.ext.unaryPlus
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

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
        lib{
            buildFeatures {
                compose=true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = libs.findVersion("androidxComposeCompiler").get().toString()
            }
        }
        with(libs) {
            dependencies {
                implementDependency("core.ktx")
                implementDependency("material3")
                implementDependency("ui.tooling")
                implementDependency("activity.compose")
                implementDependency("lifecycle.viewmodel.compose")
                implementDependency("compose.runtime")
            }
        }
    }

}