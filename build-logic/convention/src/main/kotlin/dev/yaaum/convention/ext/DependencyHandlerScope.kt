package dev.yaaum.convention.ext

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * DSL wrapper for easy dependency implementation
 *
 * @param value dependency to implement
 * @receiver DependencyHandlerScope
 * @receiver VersionCatalog
 *
 * ```
 * dependencies {
 *      implementDependency("core.ktx")
 * }
 * ```
 */
context(VersionCatalog)
fun DependencyHandlerScope.implementDependency(value: String) {
    add("implementation", this@VersionCatalog.findLibrary(value).get())
}

/**
 * DSL wrapper for easy project implementation
 *
 * @receiver DependencyHandlerScope
 * @receiver VersionCatalog
 * @param value project to implement
 *
 * ```
 * dependencies {
 *      implementProject("core:ui")
 * }
 * ```
 */
context(Project)
@Suppress("unused")
fun DependencyHandlerScope.implementProject(value: String) {
    add("implementation", project(value))
}