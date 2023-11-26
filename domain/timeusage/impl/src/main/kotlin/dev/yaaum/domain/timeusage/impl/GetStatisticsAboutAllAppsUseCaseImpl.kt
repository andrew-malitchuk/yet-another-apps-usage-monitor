package dev.yaaum.domain.timeusage.impl

import arrow.core.Either
import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.GetStatisticsAboutAllAppsUseCase
import dev.yaaum.domain.timeusage.model.TimeUsageDomainModel
import dev.yaaum.domain.timeusage.model.toDomainModel

/**
 * Get statistics about all application
 *
 * @return monad result: application time usage
 *
 * @see GetStatisticsAboutAllAppsUseCase
 */
class GetStatisticsAboutAllAppsUseCaseImpl(
    private val timeUsageRepository: TimeUsageRepository,
) : GetStatisticsAboutAllAppsUseCase {

    override suspend fun invoke(): Either<BaseDomainError, List<TimeUsageDomainModel>> {
        return try {
            Either.Right(timeUsageRepository.getApplicationsUsage().map { it.toDomainModel() })
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    exception = ex,
                ),
            )
        }
    }
}
