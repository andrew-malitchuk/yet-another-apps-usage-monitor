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

/**
 * TODO: test me
 * TODO: kdoc
 */
fun getDaysOfWeekFromTodayToXDaysAgo(daysAgo: Int): List<Int> {
    val daysOfWeekList = mutableListOf<Int>()
    val calendar = Calendar.getInstance()
    // TODO: recode
    @Suppress("UnusedPrivateProperty")
    for (i in 0 until daysAgo) {
        val weekdayNumber = calendar.get(Calendar.DAY_OF_WEEK)
        daysOfWeekList.add(weekdayNumber)
        calendar.add(Calendar.DAY_OF_YEAR, -1)
    }
    return daysOfWeekList
}
