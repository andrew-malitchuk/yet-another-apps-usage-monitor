package dev.yaaum.domain.configuration

import arrow.core.raise.Raise
import dev.yaaum.domain.core.error.base.BaseDomainError

interface SetOnboardingFinishedUseCase {
    /**
     * Update exist configuration about onboarding shown status
     *
     * @param value is onboarding shown?
     *
     * @receiver BaseDomainError
     */
    context (Raise<BaseDomainError>)
    suspend operator fun invoke(value: Boolean)
}
