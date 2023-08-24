package dev.yaaum.convention.conventionplugin.common

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.Lint
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

@Suppress("unused")
class LintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                lint.apply {

                    disable.apply {
                        add("TypographyFractions")
                    }
//                checkDependencies = true
                    abortOnError = true
                    ignoreWarnings = false
                }
            }
        }
    }
}