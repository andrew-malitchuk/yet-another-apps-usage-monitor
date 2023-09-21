package dev.yaaum.domain.configuration

import arrow.core.raise.Raise
import dev.yaaum.domain.configuration.model.ConfigurationDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

interface SetOrUpdateConfigurationUseCase {
    context (Raise<BaseDomainError>)
    suspend operator fun invoke(value: ConfigurationDomainModel)
}
