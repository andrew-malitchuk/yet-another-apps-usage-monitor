package dev.yaaum.convention.conventionplugin.common

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jmailen.gradle.kotlinter.KotlinterExtension


@Suppress("unused")
class KtlintConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jmailen.kotlinter")
            }
            extensions.getByType<KotlinterExtension>().apply {

            }
        }
    }

}