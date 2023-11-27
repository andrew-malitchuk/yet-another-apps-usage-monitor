package dev.yaaum.domain.applications.impl

import arrow.core.Either
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.domain.applications.GetAllAppsUseCase
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.applications.model.toDomainModel
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class GetAllAppsUseCaseImpl(
    private val applicationsRepository: ApplicationsRepository,
) : GetAllAppsUseCase {
    override suspend fun invoke(): Either<BaseDomainError, List<ApplicationsDomainModel>> {
        return try {
            Either.Right(applicationsRepository.getAllApplications().map { it.toDomainModel() })
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
