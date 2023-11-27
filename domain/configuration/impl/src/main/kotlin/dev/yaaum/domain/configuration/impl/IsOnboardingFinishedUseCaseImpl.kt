package dev.yaaum.domain.configuration.impl

import arrow.core.Either
import dev.yaaum.data.repository.configuration.ConfigurationRepository
import dev.yaaum.domain.configuration.IsOnboardingFinishedUseCase
import dev.yaaum.domain.configuration.model.toDomainModel
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class IsOnboardingFinishedUseCaseImpl(
    private val configurationRepository: ConfigurationRepository,
) : IsOnboardingFinishedUseCase {

    override suspend fun invoke(): Either<BaseDomainError, Boolean> {
        return try {
            configurationRepository.getCurrentConfiguration()?.toDomainModel()?.run {
                Either.Right(this.isOnboardingFinished ?: false)
            } ?: run {
                Either.Left(
                    NoDataDomainError(),
                )
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
