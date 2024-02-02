package dev.yaaum.domain.timeusage

import arrow.core.Either
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.model.WeekStatisticDomainModel

/**
 * Return app usage statistic per week
 *
 * @param packageName
 *
 * @return usage by user's application per week
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
interface GetWeekStatisticUseCase {
    suspend operator fun invoke(
        packageName: String,
    ): Either<BaseDomainError, WeekStatisticDomainModel>
}
