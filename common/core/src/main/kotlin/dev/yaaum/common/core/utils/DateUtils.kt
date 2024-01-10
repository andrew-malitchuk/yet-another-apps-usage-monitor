package dev.yaaum.common.core.utils

import java.util.Calendar

/**
 * TODO: test me
 * TODO: kdoc
 */
fun getBeginningOfDayTimestamp(): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)

    return calendar.timeInMillis
}
