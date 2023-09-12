package dev.yaaum.domain.timeusage

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.model.TimeUsageDomainModel

/**
 * Get statistics about all application
 *
 * @return monad result: application time usage
 *
 * @see GetStatisticsAboutAllAppsUseCaseImpl
 */
interface GetStatisticsAboutAllAppsUseCase {
    suspend operator fun invoke(): Either<BaseDomainError, List<TimeUsageDomainModel>>
}
