package dev.yaaum.domain.timeusage

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.model.TimeUsageDomainModel

/**
 * Return the list of applications limited by [top] item count;
 *
 * @param top limit count
 *
 * @return monad result; BaseDomainError or list of applications
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
interface GetTopAppsWithHighestUsageUseCase {
    suspend operator fun invoke(top: Int): Either<BaseDomainError, List<TimeUsageDomainModel>>
}
