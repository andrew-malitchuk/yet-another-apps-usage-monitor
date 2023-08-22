package dev.yaaum.convention.config

import org.gradle.api.JavaVersion

object ProjectConfig {

    const val APPLICATION_ID = "dev.yaaum.app"

    object SDK {
        const val MIN_SDK = 24
        const val TARGET_SDK = 34
        const val COMPILE_SDK = TARGET_SDK
    }

    val JAVA_VERSION = JavaVersion.VERSION_19

    val KOTLIN_VERSION = "19"
}