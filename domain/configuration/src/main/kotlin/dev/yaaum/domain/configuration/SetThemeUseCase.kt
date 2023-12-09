package dev.yaaum.domain.configuration

import arrow.core.raise.Raise
import dev.yaaum.domain.core.error.base.BaseDomainError

interface SetThemeUseCase {
    context (Raise<BaseDomainError>)
    suspend operator fun invoke(value: String)
}
