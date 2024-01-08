package dev.yaaum.domain.timeusage

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError

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
interface GetTotalUsageOfChosenApplicationUseCase {
    suspend operator fun invoke(
        beginTime: Long,
        endTime: Long,
    ): Either<BaseDomainError, Long>
}
