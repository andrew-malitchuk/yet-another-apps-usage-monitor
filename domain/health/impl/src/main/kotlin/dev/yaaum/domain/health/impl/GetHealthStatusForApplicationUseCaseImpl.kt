package dev.yaaum.domain.health.impl

import arrow.core.Either
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.health.GetHealthStatusForApplicationUseCase
import dev.yaaum.domain.health.model.HealthStatusDomainModel
import dev.yaaum.domain.health.model.getStatus
import dev.yaaum.domain.timeusage.GetApplicationUsageUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfChosenApplicationUseCase

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
    private val getTotalUsageOfChosenApplicationUseCase: GetTotalUsageOfChosenApplicationUseCase,
    private val getApplicationUsageUseCase: GetApplicationUsageUseCase,
) : GetHealthStatusForApplicationUseCase {

    override suspend fun invoke(
        packageName: String,
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, HealthStatusDomainModel> {
        return try {
            val generalTimeUsage = getApplicationUsageUseCase(
                beginTime = beginTime,
                endTime = endTime,
            )

            generalTimeUsage.fold({
                Either.Left(
                    it,
                )
            }, { result ->
                // TODO: fix
                if (result.totalChosenAppsUsage != 0L && result.totalAppsUsage != 0L) {
                    val percent =
                        (
                            generalTimeUsage.getOrNull()?.totalChosenAppsUsage!!.toFloat() /
                                generalTimeUsage.getOrNull()?.totalAppsUsage!!.toFloat()
                            )

                    Either.Right(
                        HealthStatusDomainModel(
                            percent = percent,
                            status = getStatus(percent),
                        ),
                    )
                } else {
                    Either.Left(
                        NoDataDomainError(),
                    )
                }
            })
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
