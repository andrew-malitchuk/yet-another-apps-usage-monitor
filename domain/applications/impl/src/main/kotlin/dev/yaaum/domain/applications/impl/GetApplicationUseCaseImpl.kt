package dev.yaaum.domain.applications.impl

import arrow.core.Either
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.domain.applications.GetApplicationUseCase
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.applications.model.toDomainModel
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class GetApplicationUseCaseImpl(
    private val applicationsRepository: ApplicationsRepository,
) : GetApplicationUseCase {
    override suspend fun invoke(packageName: String): Either<BaseDomainError, ApplicationsDomainModel> {
        return try {
            val result = applicationsRepository.getAllApplications().firstOrNull {
                it.packageName == packageName
            }?.toDomainModel()

            if (result == null) {
                Either.Left(NoDataDomainError())
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
