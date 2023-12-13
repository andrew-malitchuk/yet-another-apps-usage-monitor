package dev.yaaum.domain.applications

import arrow.core.Either
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Get application by it's [packageName]
 *
 * @param packageName
 *
 * @return monad result; BaseDomainError or application entity
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
interface GetApplicationUseCase {
    suspend operator fun invoke(packageName: String): Either<BaseDomainError, ApplicationsDomainModel>
}
