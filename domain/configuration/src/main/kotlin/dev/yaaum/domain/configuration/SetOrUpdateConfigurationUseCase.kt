package dev.yaaum.domain.configuration

import arrow.core.raise.Raise
import dev.yaaum.domain.configuration.model.ConfigurationDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

interface SetOrUpdateConfigurationUseCase {
    /**
     * Update exist configuration or add new one
     *
     * @param value configuration to set or update
     *
     * @receiver BaseDomainError
     */
    context (Raise<BaseDomainError>)
    suspend operator fun invoke(value: ConfigurationDomainModel)
}
