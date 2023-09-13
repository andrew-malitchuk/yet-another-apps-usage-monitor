package dev.yaaum.core.common.ext

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

/**
 * Return time from formatted date string, in seconds
 *
 * @param pattern pattern to parse input date-string
 * @param locale the locale whose date format symbols should be used
 * @return seconds
 */
// TODO: test
fun String.asTime(pattern: String, locale: Locale = Locale.US): Long {
    if (isEmpty()) return 0L
    return try {
        val formatter = SimpleDateFormat(pattern, locale)
        (formatter.parse(this)?.time ?: 0L) / TimeUnit.SECONDS.toMillis(1)
    } catch (ex: Exception) {
        0L
    }
}
