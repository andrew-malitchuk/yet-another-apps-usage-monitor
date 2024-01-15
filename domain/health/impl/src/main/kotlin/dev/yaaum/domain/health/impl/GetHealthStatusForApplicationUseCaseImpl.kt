package dev.yaaum.domain.health.impl

import arrow.core.Either
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.health.GetHealthStatusForApplicationUseCase
import dev.yaaum.domain.health.model.HealthStatusDomainModel
import dev.yaaum.domain.health.model.getStatus
import dev.yaaum.domain.timeusage.GetApplicationUsageUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfUserApplicationsUseCase

/**
 * Return health status for certain application
 *
 * @param packageName
 * @param beginTime
 * @param endTime
 *
 * @return health status
 */
// TODO: test me
@Suppress("KDocUnresolvedReference", "UnusedPrivateProperty")
class GetHealthStatusForApplicationUseCaseImpl(
    private val getTotalUsageOfUserApplicationsUseCase: GetTotalUsageOfUserApplicationsUseCase,
    private val getApplicationUsageUseCase: GetApplicationUsageUseCase,
) : GetHealthStatusForApplicationUseCase {

    override suspend fun invoke(
        packageName: String,
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, HealthStatusDomainModel> {
        return try {
            val applicationUsage = getApplicationUsageUseCase(
                packageName = packageName,
            ).getOrNull()
            val userApplicationsUsage = getTotalUsageOfUserApplicationsUseCase(
                beginTime,
                endTime,
            ).getOrNull()

            if (applicationUsage == null || userApplicationsUsage == null) {
                Either.Left(
                    NoDataDomainError(),
                )
            } else {
                val percent =
                    (
                        applicationUsage.totalTimeInForeground
                            ?: 0L
                        ).toFloat() / userApplicationsUsage.toFloat()

                Either.Right(
                    HealthStatusDomainModel(
                        percent = percent,
                        status = getStatus(percent),
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
