package dev.yaaum.domain.configuration

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError

interface GetThemeUseCase {
    suspend operator fun invoke(): Either<BaseDomainError, String>
}
