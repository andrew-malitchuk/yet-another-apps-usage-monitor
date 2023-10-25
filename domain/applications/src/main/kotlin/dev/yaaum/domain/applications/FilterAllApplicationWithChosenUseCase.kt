package dev.yaaum.domain.applications

import arrow.core.Either
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.core.model.SortOrder

interface FilterAllApplicationWithChosenUseCase {
    suspend operator fun invoke(
        query: String?,
        sortOrder: SortOrder = SortOrder.ASC,
    ): Either<BaseDomainError, List<ApplicationsDomainModel>>
}
