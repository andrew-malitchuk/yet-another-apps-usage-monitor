package dev.yaaum.domain.timeusage.impl

import arrow.core.Either
import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.GetTotalUsageOfAllApplicationUseCase
import java.util.Calendar

/**
 * Return total usage of all application by some period
 *
 * @param beginTime
 * @param endTime
 *
 * @return total usage by all application
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
class GetTotalUsageOfAllApplicationUseCaseImpl(
    private val timeUsageRepository: TimeUsageRepository,
) : GetTotalUsageOfAllApplicationUseCase {

    override suspend fun invoke(
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, Long> {
        return try {
            val result = timeUsageRepository.getApplicationsUsage(
                beginTime = getMillisOfDay(),
                endTime = Calendar.getInstance().timeInMillis,
            ).sumOf { timeUsage ->
                timeUsage.totalTimeInForeground ?: 0
            }
            Either.Right(result)
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }

    fun getMillisOfDay(): Long {
        // Get the current calendar instance
        val calendar = Calendar.getInstance()

        // Reset hours, minutes, seconds, and milliseconds to the beginning of the day
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        // Get the millisecond of the beginning of the day
        return calendar.timeInMillis
    }
}
