package dev.yaaum.domain.timeusage.impl

import arrow.core.Either
import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.domain.core.error.SomethingHappensError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.GetTopAppsWithHighestUsageUseCase
import dev.yaaum.domain.timeusage.model.TimeUsageDomainModel
import dev.yaaum.domain.timeusage.model.toDomainModel

class GetTopAppsWithHighestUsageUseCaseImpl(
    private val timeUsageRepository: TimeUsageRepository,
) : GetTopAppsWithHighestUsageUseCase {

    override suspend fun invoke(top: Int): Either<BaseDomainError, List<TimeUsageDomainModel>> {
        return try {
            val list = timeUsageRepository.getApplicationsUsage().sortedByDescending { it.totalTimeInForeground }
            Either.Right(list.take(top).map { it.toDomainModel() })
        } catch (ex: Exception) {
            Either.Left(
                SomethingHappensError(
                    exception = ex,
                ),
            )
        }
    }
}
