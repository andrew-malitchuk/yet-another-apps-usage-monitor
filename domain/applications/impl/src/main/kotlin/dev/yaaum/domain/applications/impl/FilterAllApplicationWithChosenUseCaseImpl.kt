package dev.yaaum.domain.applications.impl

import arrow.core.Either
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.domain.applications.FilterAllApplicationWithChosenUseCase
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.applications.model.toDomainModel
import dev.yaaum.domain.core.error.SomethingHappensError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.core.model.SortOrder

class FilterAllApplicationWithChosenUseCaseImpl(
    private val applicationsRepository: ApplicationsRepository,
) : FilterAllApplicationWithChosenUseCase {

    override suspend fun invoke(
        query: String?,
        sortOrder: SortOrder,
    ): Either<BaseDomainError, List<ApplicationsDomainModel>> {
        return try {
            val allApps = applicationsRepository.getAllApplications().map { it.toDomainModel() }
            val userChosenApps =
                applicationsRepository.getAllChosenApplications().map { it.toDomainModel() }

            var validApps = allApps.filter {
                (it.packageName?.contains(query ?: "") ?: false)
            }
            validApps = if (sortOrder == SortOrder.ASC) {
                validApps.sortedBy {
                    it.packageName
                }
            } else {
                validApps.sortedByDescending {
                    it.packageName
                }
            }

            userChosenApps.forEach { chosen ->
                validApps.firstOrNull { it.packageName == chosen.packageName }?.let {
                    it.isChosen = true
                }
            }
            Either.Right(
                validApps,
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
