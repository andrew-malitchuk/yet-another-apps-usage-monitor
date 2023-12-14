package dev.yaaum.domain.health.impl

import arrow.core.Either
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.health.GetGeneralTimeUsageStatisticUseCase
import dev.yaaum.domain.health.model.GeneralTimeUsageStatisticDomainModel
import dev.yaaum.domain.timeusage.GetTotalUsageOfAllApplicationUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfChosenApplicationUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfUserApplicationsUseCase

/**
 * Return general statistic of application usage by some period
 *
 * @param beginTime
 * @param endTime
 *
 * @return total general statistic
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
class GetGeneralTimeUsageStatisticUseCaseImpl(
    private val getTotalUsageOfAllApplicationUseCase: GetTotalUsageOfAllApplicationUseCase,
    private val getTotalUsageOfChosenApplicationUseCase: GetTotalUsageOfChosenApplicationUseCase,
    private val getTotalUsageOfUserApplicationsUseCase: GetTotalUsageOfUserApplicationsUseCase,
) : GetGeneralTimeUsageStatisticUseCase {

    override suspend fun invoke(
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, GeneralTimeUsageStatisticDomainModel> {
        return try {
            val chosenApplicationUsage =
                getTotalUsageOfChosenApplicationUseCase(beginTime, endTime).getOrNull()
            val usersApplicationUsage =
                getTotalUsageOfUserApplicationsUseCase(beginTime, endTime).getOrNull()
            val allApplicationUsage =
                getTotalUsageOfAllApplicationUseCase(beginTime, endTime).getOrNull()

            if (chosenApplicationUsage == null || usersApplicationUsage == null || allApplicationUsage == null) {
                Either.Left(
                    NoDataDomainError(),
                )
            } else {
                Either.Right(
                    GeneralTimeUsageStatisticDomainModel(
                        totalChosenAppsUsage = chosenApplicationUsage,
                        totalUsersAppsUsage = usersApplicationUsage,
                        totalAppsUsage = allApplicationUsage,
                    ),
                )
            }
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
