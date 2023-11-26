package dev.yaaum.domain.configuration.impl

import arrow.core.Either
import dev.yaaum.data.repository.configuration.ConfigurationRepository
import dev.yaaum.domain.configuration.GetCurrentConfigurationUseCase
import dev.yaaum.domain.configuration.model.ConfigurationDomainModel
import dev.yaaum.domain.configuration.model.toDomainModel
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class GetCurrentConfigurationUseCaseImpl(
    private val configurationRepository: ConfigurationRepository,
) : GetCurrentConfigurationUseCase {

    override suspend fun invoke(): Either<BaseDomainError, ConfigurationDomainModel> {
        return try {
            configurationRepository.getCurrentConfiguration()?.toDomainModel()?.run {
                Either.Right(this)
            } ?: run {
                Either.Left(
                    NoDataDomainError(),
                )
            }
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    exception = ex,
                ),
            )
        }
    }
}
