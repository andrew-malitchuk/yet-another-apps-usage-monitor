package dev.yaaum.domain.health

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.health.model.GeneralTimeUsageStatisticDomainModel

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
interface GetGeneralTimeUsageStatisticUseCase {
    suspend operator fun invoke(
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, GeneralTimeUsageStatisticDomainModel>
}
