package dev.yaaum.domain.health.impl

import arrow.core.Either
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.health.GetGeneralTimeUsageStatisticUseCase
import dev.yaaum.domain.health.GetHealthStatusUseCase
import dev.yaaum.domain.health.model.HealthStatusDomainModel
import dev.yaaum.domain.health.model.getStatus

/**
 * Return health status
 *
 * @param beginTime
 * @param endTime
 *
 * @return health status
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
class GetHealthStatusUseCaseImpl(
    private val getGeneralTimeUsageStatisticUseCase: GetGeneralTimeUsageStatisticUseCase,
) : GetHealthStatusUseCase {

    override suspend fun invoke(
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, HealthStatusDomainModel> {
        return try {
            val generalTimeUsage = getGeneralTimeUsageStatisticUseCase(
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
