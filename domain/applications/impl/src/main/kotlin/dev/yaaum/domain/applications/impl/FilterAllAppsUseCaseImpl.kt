package dev.yaaum.domain.applications.impl

import arrow.core.Either
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.domain.applications.FilterAllAppsUseCase
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.applications.model.toDomainModel
import dev.yaaum.domain.core.error.SwwDomainError
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
            var validApps = all.filter {
                (it.applicationName?.contains(query ?: "") ?: false)
            }
            validApps = if (sortOrder == SortOrder.ASC) {
                validApps.sortedBy {
                    it.applicationName
                }
            } else {
                validApps.sortedByDescending {
                    it.applicationName
                }
            }
            Either.Right(
                validApps.map { it.toDomainModel() },
            )
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
