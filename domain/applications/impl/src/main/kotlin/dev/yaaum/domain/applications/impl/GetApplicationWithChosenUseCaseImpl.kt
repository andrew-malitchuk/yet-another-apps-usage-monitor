package dev.yaaum.domain.applications.impl

import arrow.core.Either
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.domain.applications.GetApplicationWithChosenUseCase
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.applications.model.toDomainModel
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class GetApplicationWithChosenUseCaseImpl(
    private val applicationsRepository: ApplicationsRepository,
) : GetApplicationWithChosenUseCase {
    override suspend fun invoke(): Either<BaseDomainError, List<ApplicationsDomainModel>> {
        return try {
            val allApps = applicationsRepository.getAllApplications().map { it.toDomainModel() }
            val userChosenApps =
                applicationsRepository.getAllChosenApplications().map { it.toDomainModel() }

            userChosenApps.forEach { chosen ->
                allApps.firstOrNull { it.packageName == chosen.packageName }?.let {
                    it.isChosen = true
                }
            }

            Either.Right(allApps)
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
