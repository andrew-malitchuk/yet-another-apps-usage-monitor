package dev.yaaum.domain.configuration.impl

import arrow.core.raise.Raise
import dev.yaaum.data.repository.configuration.ConfigurationRepository
import dev.yaaum.domain.configuration.SetOrUpdateConfigurationUseCase
import dev.yaaum.domain.configuration.model.ConfigurationDomainModel
import dev.yaaum.domain.configuration.model.toRepoModel
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class SetOrUpdateConfigurationUseCaseImpl(
    private val configurationRepository: ConfigurationRepository,
) : SetOrUpdateConfigurationUseCase {

    context(Raise<BaseDomainError>)
    override suspend fun invoke(value: ConfigurationDomainModel) {
        try {
            configurationRepository.setOrUpdateConfiguration(
                value.toRepoModel(),
            )
        } catch (ex: Exception) {
            raise(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
