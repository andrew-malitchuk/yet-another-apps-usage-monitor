package dev.yaaum.domain.timeusage

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.model.TimeUsageDomainModel

/**
 * Get statistics about application by it's [packageName]
 *
 * @param packageName
 *
 * @return monad result: application time usage
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
interface GetApplicationUsageUseCase {

    suspend operator fun invoke(packageName: String): Either<BaseDomainError, TimeUsageDomainModel>
}
