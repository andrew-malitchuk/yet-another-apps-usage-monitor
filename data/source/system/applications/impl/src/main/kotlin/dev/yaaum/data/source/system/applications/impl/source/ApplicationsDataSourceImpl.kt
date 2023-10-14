package dev.yaaum.data.source.system.applications.impl.source

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import dev.yaaum.data.source.system.applications.model.ApplicationSystemModel
import dev.yaaum.data.source.system.applications.model.toApplicationSystemModel
import dev.yaaum.data.source.system.applications.source.ApplicationsDataSource
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ApplicationsDataSourceImpl(
    private val context: Context,
) : ApplicationsDataSource {

    override suspend fun getAllApplications(): List<ApplicationSystemModel> {
        return suspendCoroutine { continuation ->
            val applications = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                context.packageManager.getInstalledApplications(
                    PackageManager.ApplicationInfoFlags.of(
                        0L,
                    ),
                )
            } else {
                context.packageManager.getInstalledApplications(0)
            }
            continuation.resume(
                applications.map { it.toApplicationSystemModel(context) },
            )
        }
    }

    override suspend fun getUserApplications(): List<ApplicationSystemModel> {
        return suspendCoroutine { continuation ->
            val mainIntent = Intent(Intent.ACTION_MAIN, null).also {
                it.addCategory(Intent.CATEGORY_LAUNCHER)
            }

            val resolvedInfos = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                context.packageManager.queryIntentActivities(
                    mainIntent,
                    PackageManager.ResolveInfoFlags.of(0L),
                )
            } else {
                context.packageManager.queryIntentActivities(mainIntent, 0)
            }
            continuation.resume(
                resolvedInfos.map { it.toApplicationSystemModel() },
            )
        }
    }
}
