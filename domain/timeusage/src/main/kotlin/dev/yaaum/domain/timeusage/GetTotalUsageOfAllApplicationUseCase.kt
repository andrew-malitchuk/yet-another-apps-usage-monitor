package dev.yaaum.domain.timeusage

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError

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
interface GetTotalUsageOfAllApplicationUseCase {
    suspend operator fun invoke(
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, Long>
}
