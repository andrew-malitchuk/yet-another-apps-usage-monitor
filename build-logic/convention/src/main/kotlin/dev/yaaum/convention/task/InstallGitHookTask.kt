package dev.yaaum.convention.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * Simple Gradle task to copy githook config file
 * from: `<root-dir>/config/githook/pre-commit`
 * to: `.git/hooks`.
 *
 * Installed in AndroidApplicationConventionPlugin & named as `installGitHookTask` command.
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
abstract class InstallGitHookTask : DefaultTask() {

    @TaskAction
    fun action() {
        this.project.copy {
            from(
                File(
                    this@InstallGitHookTask.project.rootProject.rootDir,
                    "config/githook/pre-commit"
                )
            )
            into {
                File(
                    this@InstallGitHookTask.project.rootProject.rootDir,
                    ".git/hooks"
                )
            }
            fileMode = 0x777
        }
    }
}