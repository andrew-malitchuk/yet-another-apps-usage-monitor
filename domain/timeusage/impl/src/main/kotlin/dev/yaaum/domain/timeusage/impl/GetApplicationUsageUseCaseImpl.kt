package dev.yaaum.domain.timeusage.impl

import arrow.core.Either
import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.GetApplicationUsageUseCase
import dev.yaaum.domain.timeusage.model.TimeUsageDomainModel
import dev.yaaum.domain.timeusage.model.toDomainModel

/**
 * Get statistics about application by it's [packageName]
 *
 * @param packageName
 *
 * @return monad result: application time usage
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
class GetApplicationUsageUseCaseImpl(
    private val timeUsageRepository: TimeUsageRepository,
) : GetApplicationUsageUseCase {

    override suspend fun invoke(
        packageName: String,
    ): Either<BaseDomainError, TimeUsageDomainModel> {
        return try {
            val result = timeUsageRepository.getApplicationsUsage()
                .firstOrNull { it.packageName == packageName }?.toDomainModel()

            if (result == null) {
                Either.Left(
                    NoDataDomainError(),
                )
            } else {
                Either.Right(result)
            }
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
