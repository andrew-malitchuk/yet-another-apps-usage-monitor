package dev.yaaum.domain.configuration.impl

import arrow.core.raise.Raise
import dev.yaaum.data.repository.configuration.ConfigurationRepository
import dev.yaaum.domain.configuration.SetThemeUseCase
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class SetThemeUseCaseImpl(
    private val configurationRepository: ConfigurationRepository,
) : SetThemeUseCase {
    context(Raise<BaseDomainError>)
    override suspend fun invoke(value: String) {
        try {
            configurationRepository.apply {
                getCurrentConfiguration()?.let { previous ->
                    configurationRepository.setOrUpdateConfiguration(
                        previous.copy(
                            themeMode = value,
                        ),
                    )
                }
            }
        } catch (ex: Exception) {
            raise(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
