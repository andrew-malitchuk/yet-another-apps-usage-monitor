package dev.yaaum.presentation.core.platform.ext

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Open links in web browser
 *
 * @param url web link
 * @receiver Context
 */
fun Context.openLinkInBrowser(url: String) {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(browserIntent)
}
