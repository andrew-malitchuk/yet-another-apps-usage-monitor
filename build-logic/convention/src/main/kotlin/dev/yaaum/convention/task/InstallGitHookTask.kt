package dev.yaaum.convention.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class InstallGitHookTask : DefaultTask() {

    @TaskAction
    fun foo() {
        this.project.copy {
            from(
                File(
                    this@InstallGitHookTask.project.rootProject.rootDir,
                    "config/pre-commit"
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