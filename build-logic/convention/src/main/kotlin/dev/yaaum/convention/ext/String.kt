package dev.yaaum.convention.ext

import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.DependencyHandlerScope


context(PluginManager)
operator fun String.unaryPlus() {
    apply(this)
}