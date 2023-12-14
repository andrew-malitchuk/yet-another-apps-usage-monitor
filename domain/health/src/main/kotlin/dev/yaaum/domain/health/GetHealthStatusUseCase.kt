package dev.yaaum.domain.health

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.health.model.HealthStatusDomainModel

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
interface GetHealthStatusUseCase {
    suspend operator fun invoke(
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, HealthStatusDomainModel>
}
