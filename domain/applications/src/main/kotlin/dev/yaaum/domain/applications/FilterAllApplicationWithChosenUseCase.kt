package dev.yaaum.domain.applications

import arrow.core.Either
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.core.model.SortOrder

/**
 * Filter all apps by [query]; also it's possible to sort output.
 *
 * @param query search request
 * @param sortOrder in which way result will be sorted
 *
 * @return monad result; BaseDomainError or filtered list of applications
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
interface FilterAllApplicationWithChosenUseCase {
    suspend operator fun invoke(
        query: String?,
        sortOrder: SortOrder = SortOrder.ASC,
    ): Either<BaseDomainError, List<ApplicationsDomainModel>>
}
