package dev.yaaum.host.screen

import android.app.AppOpsManager
import android.app.usage.UsageStatsManager
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Process
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Text
import dev.yaaum.common.core.ext.asDate
import java.util.Locale

class HostActivity : ComponentActivity() {

    val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("yaaum")
        }
        if (!isPermissionGranted()) {
            getContent.launch(
                Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS),
            )
        } else {
            timeConsuming()
        }

//        installedApps()
        getInstalledApps()
    }

    fun isPermissionGranted(): Boolean {
        val appOps = getSystemService(APP_OPS_SERVICE) as? AppOpsManager
        val mode = appOps?.unsafeCheckOpNoThrow(
            AppOpsManager.OPSTR_GET_USAGE_STATS,
            Process.myUid(),
            packageName,
        )
        return mode == AppOpsManager.MODE_ALLOWED
    }

    fun timeConsuming() {
        val lUsageStatsMap =
            (applicationContext.getSystemService(USAGE_STATS_SERVICE) as? UsageStatsManager)
                ?.queryAndAggregateUsageStats(
                    0,
                    System.currentTimeMillis(),
                )
        lUsageStatsMap?.keys?.forEach { key ->
            val usage = lUsageStatsMap[key]
            if (usage?.totalTimeVisible != 0L) {
                val foo = usage?.totalTimeVisible?.asDate("HH:mm:ss:SS", true, Locale.US)
                Log.d("foo", "$foo | ${usage?.packageName}")
            }
        }
    }

    private fun getInstalledApps(): List<AppList>? {
        val apps: MutableList<AppList> = ArrayList()
        val packs = applicationContext.packageManager.getInstalledPackages(0)
        // List<PackageInfo> packs = getPackageManager().getInstalledPackages(PackageManager.GET_PERMISSIONS);
        for (i in packs.indices) {
            val p = packs[i]
            if (!isSystemPackage(p)) {
                val appName =
                    p.applicationInfo.loadLabel(applicationContext.packageManager).toString()
                val icon = p.applicationInfo.loadIcon(
                    applicationContext.packageManager,
                )
                val packages = p.applicationInfo.packageName
                apps.add(AppList(appName, icon, packages))
            }
        }
        return apps
    }

    private fun isSystemPackage(pkgInfo: PackageInfo): Boolean {
        return pkgInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0
    }

    class AppList(val name: String, var icon: Drawable, val packages: String)
}
