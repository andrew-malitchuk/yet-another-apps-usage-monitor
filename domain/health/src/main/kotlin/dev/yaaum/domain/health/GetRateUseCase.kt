package dev.yaaum.domain.health

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Return health rate in a range A..F
 *
 * @return health rate
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
interface GetRateUseCase {
    suspend operator fun invoke(): Either<BaseDomainError, String>
}
