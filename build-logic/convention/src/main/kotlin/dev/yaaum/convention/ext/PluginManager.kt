package dev.yaaum.convention.ext

import org.gradle.api.plugins.PluginManager


fun PluginManager.id(value: String) = apply(value)
