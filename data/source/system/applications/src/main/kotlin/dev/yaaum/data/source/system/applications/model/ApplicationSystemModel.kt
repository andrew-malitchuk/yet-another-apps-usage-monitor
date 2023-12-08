package dev.yaaum.data.source.system.applications.model

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.ResolveInfo
import android.content.res.Resources
import dev.yaaum.data.source.system.core.model.base.BaseSystemModel

/**
 * Represent information about application
 */
data class ApplicationSystemModel(
    val uuid: Int?,
    val packageName: String?,
    val applicationName: String?,
) : BaseSystemModel

fun ApplicationInfo.toApplicationSystemModel(context: Context): ApplicationSystemModel {
    val applicationName = try {
        context.packageManager.getApplicationInfo(packageName, 0).loadLabel(context.packageManager)
            .toString()
    } catch (ex: Resources.NotFoundException) {
        null
    }
    return ApplicationSystemModel(
        uuid = uid,
        packageName = this.packageName,
        applicationName = applicationName,
    )
}

fun ResolveInfo.toApplicationSystemModel(context: Context): ApplicationSystemModel {
    val applicationName = try {
        context.packageManager.getApplicationInfo(this.activityInfo.packageName, 0).loadLabel(context.packageManager)
            .toString()
    } catch (ex: Resources.NotFoundException) {
        null
    }
    return ApplicationSystemModel(
        uuid = null,
        packageName = this.activityInfo.packageName,
        applicationName = applicationName,
    )
}
