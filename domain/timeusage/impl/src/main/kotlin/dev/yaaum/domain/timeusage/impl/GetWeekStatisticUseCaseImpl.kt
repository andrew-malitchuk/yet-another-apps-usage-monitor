package dev.yaaum.domain.timeusage.impl

import arrow.core.Either
import dev.yaaum.common.core.utils.getBeginningOfDayTimestamp
import dev.yaaum.common.core.utils.getDaysOfWeekFromTodayToXDaysAgo
import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.data.repository.timeusage.model.TimeUsageRepoModel
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.GetWeekStatisticUseCase
import dev.yaaum.domain.timeusage.model.DayUsageStatisticDomainModel
import dev.yaaum.domain.timeusage.model.WeekStatisticDomainModel
import java.util.concurrent.TimeUnit

/**
 * Return app usage statistic per week
 *
 * @param packageName
 * @param currentTime
 *
 * @return usage by user's application per week
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
class GetWeekStatisticUseCaseImpl(
    private val timeUsageRepository: TimeUsageRepository,
) : GetWeekStatisticUseCase {

    override suspend fun invoke(
        packageName: String,
    ): Either<BaseDomainError, WeekStatisticDomainModel> {
        var beginTimeTemp = getBeginningOfDayTimestamp()
        var endTimeTemp = System.currentTimeMillis()

        val timeUsageByRange = mutableListOf<TimeUsageRepoModel?>()

        repeat(DAYS) {
            val applicationUsage = timeUsageRepository.getApplicationUsage(
                packageName = packageName,
                beginTime = beginTimeTemp,
                endTime = endTimeTemp,
            )
            timeUsageByRange.add(applicationUsage)
            endTimeTemp = beginTimeTemp
            beginTimeTemp -= TimeUnit.DAYS.toMillis(1)
        }

        val dayUsageList = mutableListOf<DayUsageStatisticDomainModel>()
        val last7Days = getDaysOfWeekFromTodayToXDaysAgo(DAYS)
        @Suppress("ForEachOnRange")
        (0..<DAYS).forEach { dayIndex ->
            dayUsageList.add(
                DayUsageStatisticDomainModel(
                    last7Days[dayIndex],
                    timeUsageByRange[dayIndex]?.totalTimeInForeground ?: 0L,
                ),
            )
        }

        return Either.Right(
            WeekStatisticDomainModel(
                timeUsageByRange[0]?.packageName,
                timeUsageByRange[0]?.applicationName,
                dayUsageList.toSet(),
            ),
        )
    }

    companion object {
        const val DAYS = 7
    }
}
