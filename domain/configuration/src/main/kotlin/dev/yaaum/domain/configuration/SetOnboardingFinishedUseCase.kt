package dev.yaaum.domain.configuration

import arrow.core.raise.Raise
import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Update exist configuration about onboarding shown status
 *
 * @param value is onboarding shown?
 *
 * @receiver BaseDomainError
 */
@Suppress("KDocUnresolvedReference")
interface SetOnboardingFinishedUseCase {
    context (Raise<BaseDomainError>)
    suspend operator fun invoke(value: Boolean)
}
