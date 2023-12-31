package dev.yaaum.domain.applications

import arrow.core.raise.Raise
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Remove certain app from "chosen" list.
 *
 * @param value app to remove from chosen list
 *
 * @return BaseDomainError
 */
// TODO: test me
interface RemoveAppFromChosenUseCase {
    context (Raise<BaseDomainError>)
    suspend operator fun invoke(value: ApplicationsDomainModel)
}
