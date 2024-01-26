package dev.yaaum.domain.health.impl

import arrow.core.Either
import dev.yaaum.common.core.utils.getBeginningOfDayTimestamp
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.health.GetRateUseCase
import dev.yaaum.domain.timeusage.GetTotalUsageOfChosenApplicationUseCase
import java.util.concurrent.TimeUnit

/**
 * Return health rate in a range A..F
 *
 * @return health rate
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
class GetRateUseCaseImpl(
    private val getTotalUsageOfChosenApplicationUseCase: GetTotalUsageOfChosenApplicationUseCase,
) : GetRateUseCase {

    override suspend fun invoke(): Either<BaseDomainError, String> {
        val beggingOfTheDay = getBeginningOfDayTimestamp()
        val currentDayUsage = getTotalUsageOfChosenApplicationUseCase(
            beginTime = beggingOfTheDay,
            endTime = System.currentTimeMillis(),
        ).getOrNull()
        val dayBeforeUsage = getTotalUsageOfChosenApplicationUseCase(
            beginTime = (beggingOfTheDay - TimeUnit.DAYS.toMillis(1)),
            endTime = beggingOfTheDay,
        ).getOrNull()

        if (currentDayUsage == null || dayBeforeUsage == null) {
            return Either.Left(
                NoDataDomainError(),
            )
        }

        val ration = currentDayUsage.toFloat() / dayBeforeUsage.toFloat()

        @Suppress("MagicNumber")
        val result = when (ration) {
            0f -> "F"
            in (0.1f..0.2f) -> "E"
            in (0.2f..0.4f) -> "D"
            in (0.4f..0.6f) -> "C"
            in (0.6f..0.8f) -> "B"
            else -> "A"
        }
        return Either.Right(result)
    }
}
