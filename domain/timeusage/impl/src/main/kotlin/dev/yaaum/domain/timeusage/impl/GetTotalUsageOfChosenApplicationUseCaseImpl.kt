package dev.yaaum.domain.timeusage.impl

import arrow.core.Either
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.data.repository.timeusage.model.TimeUsageRepoModel
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.GetTotalUsageOfChosenApplicationUseCase
import java.util.Calendar

/**
 * Return total usage of chosen application by some period
 *
 * @param beginTime
 * @param endTime
 *
 * @return total usage by chosen application
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
class GetTotalUsageOfChosenApplicationUseCaseImpl(
    private val timeUsageRepository: TimeUsageRepository,
    private val applicationsRepository: ApplicationsRepository,
) : GetTotalUsageOfChosenApplicationUseCase {

    override suspend fun invoke(
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, Long> {
        return try {
            val usersApplications = applicationsRepository.getAllChosenApplications()

            val allApplicationUsage = timeUsageRepository.getApplicationsUsage(
                beginTime = getMillisOfDay(),
                endTime = Calendar.getInstance().timeInMillis,
            )

            val userApplicationUsage = mutableListOf<TimeUsageRepoModel>()

            allApplicationUsage.forEach { timeUsage ->
                if (usersApplications.any { it.packageName == timeUsage.packageName }) {
                    userApplicationUsage.add(timeUsage)
                }
            }

            val result = userApplicationUsage.filter { it.totalTimeInForeground != 0L }.sumOf {
                it.totalTimeInForeground ?: 0L
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
