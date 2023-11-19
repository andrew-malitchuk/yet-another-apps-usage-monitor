package dev.yaaum.domain.applications

import arrow.core.Either
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Return apps which are marked as a "chosen"
 *
 * > Chosen - application which is marked to be tracked
 *
 * @return monad result; BaseDomainError or list of applications
 */
// TODO: test me
interface GetApplicationWithChosenUseCase {
    suspend operator fun invoke(): Either<BaseDomainError, List<ApplicationsDomainModel>>
}
