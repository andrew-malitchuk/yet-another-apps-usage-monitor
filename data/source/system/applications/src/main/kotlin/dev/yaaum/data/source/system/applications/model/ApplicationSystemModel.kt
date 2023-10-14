package dev.yaaum.data.source.system.applications.model

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.ResolveInfo
import android.content.res.Resources
import dev.yaaum.data.source.system.core.model.base.BaseSystemModel

data class ApplicationSystemModel(
    val uuid: Int?,
    val packageName: String?,
    val applicationName: String?,
) : BaseSystemModel

fun ApplicationInfo.toApplicationSystemModel(context: Context): ApplicationSystemModel {
    val applicationName = try {
        context.getString(labelRes)
    } catch (ex: Resources.NotFoundException) {
        null
    }

    return ApplicationSystemModel(
        uuid = uid,
        packageName = this.packageName,
        applicationName = applicationName,
    )
}

fun ResolveInfo.toApplicationSystemModel(): ApplicationSystemModel {
    return ApplicationSystemModel(
        uuid = null,
        packageName = this.resolvePackageName,
        applicationName = this.activityInfo.packageName,
    )
}
