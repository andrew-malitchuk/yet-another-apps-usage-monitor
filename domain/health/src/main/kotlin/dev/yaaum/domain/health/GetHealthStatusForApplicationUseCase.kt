package dev.yaaum.domain.health

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.health.model.HealthStatusDomainModel

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
@Suppress("KDocUnresolvedReference")
interface GetHealthStatusForApplicationUseCase {
    suspend operator fun invoke(
        packageName: String,
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, HealthStatusDomainModel>
}
