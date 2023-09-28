package dev.yaaum.domain.configuration

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError

interface IsOnboardingFinishedUseCase {
    /**
     * Has been onboarding already shown?
     *
     * @return monad: error or boolean
     */
    suspend operator fun invoke(): Either<BaseDomainError, Boolean>
}
