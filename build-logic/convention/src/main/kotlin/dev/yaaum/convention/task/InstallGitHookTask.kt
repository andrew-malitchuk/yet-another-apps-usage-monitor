package dev.yaaum.convention.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * Simple Gradle task to copy git hook config file
 * to `.git/hooks`.
 *
 * Installed in AndroidApplicationConventionPlugin & named as `installGitHookTask` command.
 *
 * @param from relative path to git hook config file (`<root-dir>/config/githook/pre-commit`)
 *
 * How to run:
 * ```
 * ./gradle installGitHookTask
 * ```
 *
 * __N.B.__ AndroidApplicationConventionPlugin has to be applied in your module.
 *
 * @see AndroidApplicationConventionPlugin
 * @see AndroidApplicationComposeConventionPlugin
 */
@Suppress("KDocUnresolvedReference", "SpellCheckingInspection")
abstract class InstallGitHookTask : DefaultTask() {

    /**
     * Relative path to config file
     */
    @get:Input
    abstract var from: String

    @TaskAction
    fun action() {
        this.project.copy {
            from(
                File(
                    this@InstallGitHookTask.project.rootProject.rootDir,
                    from
                )
            )
            into {
                File(
                    this@InstallGitHookTask.project.rootProject.rootDir,
                    GIT_HOOK_LOCATION
                )
            }
            fileMode = 0x777
        }
    }

    companion object {
        /**
         * Default git hook directory
         */
        const val GIT_HOOK_LOCATION = ".git/hooks"
    }
}