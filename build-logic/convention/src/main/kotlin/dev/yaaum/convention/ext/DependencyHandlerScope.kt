package dev.yaaum.convention.ext

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.DependencyHandlerScope

context(VersionCatalog)
fun DependencyHandlerScope.implementDependency(value: () -> String) {
    add("implementation", this@VersionCatalog.findLibrary(value()).get())
}

context(Project)
fun DependencyHandlerScope.implementProject(value: () -> String) {
    add("implementation", project(value()))
}