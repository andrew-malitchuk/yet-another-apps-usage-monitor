package dev.yaaum.convention.conventionplugin.android

import dev.yaaum.convention.ext.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Convention plugin for android integration tests
 *
 * @see KotlinTestConventionPlugin
 */
@Suppress("unused", "KDocUnresolvedReference")
class AndroidTestConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        plugins {

        }
    }

}