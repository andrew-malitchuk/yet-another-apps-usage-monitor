package dev.yaaum.domain.configuration.impl

import arrow.core.raise.Raise
import dev.yaaum.data.repository.configuration.ConfigurationRepository
import dev.yaaum.domain.configuration.SetOnboardingFinishedUseCase
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class SetOnboardingFinishedUseCaseImpl(
    private val configurationRepository: ConfigurationRepository,
) : SetOnboardingFinishedUseCase {

    context(Raise<BaseDomainError>)
    override suspend fun invoke(value: Boolean) {
        try {
            configurationRepository.apply {
                getCurrentConfiguration()?.let { previous ->
                    configurationRepository.setOrUpdateConfiguration(
                        previous.copy(
                            isOnboardingFinished = value,
                        ),
                    )
                }
            }
        } catch (ex: Exception) {
            raise(
                SwwDomainError(
                    exception = ex,
                ),
            )
        }
    }
}
