package dev.yaaum.domain.applications

import arrow.core.Either
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Return all user apps
 *
 * @return monad result; BaseDomainError or list of applications
 */
// TODO: test me
interface GetUserAppsUseCase {
    suspend operator fun invoke(): Either<BaseDomainError, List<ApplicationsDomainModel>>
}
