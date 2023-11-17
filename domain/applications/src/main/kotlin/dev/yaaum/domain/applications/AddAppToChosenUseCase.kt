package dev.yaaum.domain.applications

import arrow.core.raise.Raise
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Mark application as "chosen".
 *
 * > Chosen - application which is marked to be tracked
 */
// TODO: test me
interface AddAppToChosenUseCase {
    /**
     * Mark application as "chosen".
     *
     * > Chosen - application which is marked to be tracked
     *
     * @param value application to mark as a "chosen"
     *
     * @return BaseDomainError
     */
    context (Raise<BaseDomainError>)
    suspend operator fun invoke(value: ApplicationsDomainModel)
}
