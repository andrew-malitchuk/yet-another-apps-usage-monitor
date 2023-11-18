package dev.yaaum.domain.applications

import arrow.core.Either
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Return all apps on device
 *
 * @return monad result; BaseDomainError or list of applications
 */
// TODO: test me
interface GetAllAppsUseCase {
    suspend operator fun invoke(): Either<BaseDomainError, List<ApplicationsDomainModel>>
}
