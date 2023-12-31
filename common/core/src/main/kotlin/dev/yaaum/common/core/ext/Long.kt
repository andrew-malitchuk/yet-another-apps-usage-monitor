package dev.yaaum.common.core.ext

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

/**
 * Convert milliseconds into human-readable date format
 *
 * @param pattern
 * @param isEpochTimestamp if true - uses unix epoch
 * @param locale the locale whose date format symbols should be used
 *
 * @return human-readable date
 */
// TODO: test
@Suppress("unused")
fun Long.asDate(
    pattern: String,
    isEpochTimestamp: Boolean = true,
    locale: Locale = Locale.US,
): String {
    if (this == 0L) return ""
    return try {
        val dateFormatTo = SimpleDateFormat(pattern, locale)
        dateFormatTo.format(
            this * if (isEpochTimestamp) {
                TimeUnit.SECONDS.toMillis(1)
            } else {
                1
            },
        )
    } catch (ex: Exception) {
        ""
    }
}

/**
 * Convert time value in long (milliseconds) into hours
 *
 * @return hours as a String
 */
// TODO: test
fun Long.asHours(): String {
    val hours = TimeUnit.MILLISECONDS.toMinutes(this)
    return hours.toString()
}
