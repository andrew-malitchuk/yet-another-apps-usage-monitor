package dev.yaaum.domain.applications

import arrow.core.raise.Raise
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

interface RemoveAppFromChosenUseCase {
    context (Raise<BaseDomainError>)
    suspend operator fun invoke(value: ApplicationsDomainModel)
}
