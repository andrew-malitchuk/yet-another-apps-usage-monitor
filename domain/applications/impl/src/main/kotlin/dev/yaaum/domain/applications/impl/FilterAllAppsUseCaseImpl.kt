package dev.yaaum.domain.applications.impl

import arrow.core.Either
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.domain.applications.FilterAllAppsUseCase
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.applications.model.toDomainModel
import dev.yaaum.domain.core.error.SomethingHappensError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.core.model.SortOrder

class FilterAllAppsUseCaseImpl(
    private val applicationsRepository: ApplicationsRepository,
) : FilterAllAppsUseCase {
    override suspend fun invoke(
        query: String?,
        sortOrder: SortOrder,
    ): Either<BaseDomainError, List<ApplicationsDomainModel>> {
        return try {
            val all = applicationsRepository.getUserApplications()
            var foo = all.filter {
                (it.applicationName?.contains(query ?: "") ?: false)
            }
            foo = if (sortOrder == SortOrder.ASC) {
                foo.sortedBy {
                    it.applicationName
                }
            } else {
                foo.sortedByDescending {
                    it.applicationName
                }
            }
            Either.Right(
                foo.map { it.toDomainModel() },
            )
        } catch (ex: Exception) {
            Either.Left(
                SomethingHappensError(
                    exception = ex,
                ),
            )
        }
    }
}
