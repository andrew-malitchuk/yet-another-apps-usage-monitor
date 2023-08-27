package dev.yaaum.convention.ext

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

/**
 * DSL wrapper for Kotlin JVM configuration
 *
 * @receiver CommonExtension
 * @param block lambda body
 *
 * ```
 * kotlinOptions{
 *      jvmTarget = ProjectConfig.KOTLIN_VERSION
 * }
 * ```
 */
fun CommonExtension<*, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}
