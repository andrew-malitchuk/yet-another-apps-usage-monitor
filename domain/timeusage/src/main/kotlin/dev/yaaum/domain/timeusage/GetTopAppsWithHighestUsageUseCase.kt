package dev.yaaum.domain.timeusage

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.model.TimeUsageDomainModel

interface GetTopAppsWithHighestUsageUseCase {
    suspend operator fun invoke(top: Int): Either<BaseDomainError, List<TimeUsageDomainModel>>
}
