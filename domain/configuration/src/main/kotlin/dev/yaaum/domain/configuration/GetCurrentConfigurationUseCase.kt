package dev.yaaum.domain.configuration

import arrow.core.Either
import dev.yaaum.domain.configuration.model.ConfigurationDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

interface GetCurrentConfigurationUseCase {
    /**
     * Return current application configuration from local store
     *
     * @return monad: error or configuration
     */
    suspend operator fun invoke(): Either<BaseDomainError, ConfigurationDomainModel>
}
