@file:Suppress("unused")

package dev.yaaum.convention.ext

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jmailen.gradle.kotlinter.KotlinterExtension

/**
 * Contains reference for `libs.versions.toml`
 *
 * @receiver Project
 */
val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

/**
 * DSL wrapper for application configuration
 *
 * @receiver Project
 * @param block lambda body
 *
 * ```
 * app {
 *      defaultConfig {
 *          applicationId = ProjectConfig.APPLICATION_ID
 *          ...
 * ```
 */
fun Project.app(block: ApplicationExtension.() -> Unit) {
    this.extensions.configure<ApplicationExtension> {
        this.block()
    }
}

/**
 * DSL wrapper for library configuration
 *
 * @receiver Project
 * @param block lambda body
 *
 * ```
 * lib {
 *      defaultConfig {
 *          applicationId = ProjectConfig.APPLICATION_ID
 *          ...
 * ```
 */
fun Project.lib(block: LibraryExtension.() -> Unit) {
    this.extensions.configure<LibraryExtension> {
        this.block()
    }
}

/**
 * DSL wrapper for simple plugin management
 *
 * @receiver Project
 * @param block lambda body
 *
 * ```
 * plugins {
 *      +"yaaum.convention.application"
 * }
 * ```
 */
fun Project.plugins(block: PluginManager.() -> Unit) {
    this.pluginManager.block()
}

/**
 * DSL wrapper for detekt configuration
 *
 * @receiver Project
 * @param block lambda body
 *
 * ```
 * detekt {
 *      buildUponDefaultConfig = true
 *      ...
 * }
 * ```
 */
fun Project.detekt(block: DetektExtension.() -> Unit) {
    val detektScope = extensions.getByType<DetektExtension>()
    detektScope.block()
}

/**
 * DSL wrapper for ktlint configuration
 *
 * @receiver Project
 * @param block lambda body
 *
 * ```
 * ktlint {
 *      ...
 * }
 * ```
 */
fun Project.ktlint(block: KotlinterExtension.() -> Unit) {
    val ktlintScope = extensions.getByType<KotlinterExtension>()
    ktlintScope.block()
}