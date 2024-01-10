package dev.yaaum.domain.timeusage.impl

import arrow.core.Either
import dev.yaaum.common.core.utils.getBeginningOfDayTimestamp
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.data.repository.timeusage.TimeUsageRepository
import dev.yaaum.data.repository.timeusage.model.TimeUsageRepoModel
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError
import dev.yaaum.domain.timeusage.GetWeekStatisticUseCase
import dev.yaaum.domain.timeusage.model.DayUsageStatisticDomainModel
import dev.yaaum.domain.timeusage.model.WeekStatisticDomainModel
import io.getstream.log.StreamLog
import io.getstream.log.streamLog
import java.util.concurrent.TimeUnit

/**
 * Return app usage statistic per week
 *
 * @param packageName
 * @param currentTime
 *
 * @return usage by user's application per week
 */
// TODO: test me
@Suppress("KDocUnresolvedReference")
class GetWeekStatisticUseCaseImpl(
    private val timeUsageRepository: TimeUsageRepository,
    private val applicationsRepository: ApplicationsRepository,
) : GetWeekStatisticUseCase {

    override suspend fun invoke(
        packageName: String,
    ): Either<BaseDomainError, WeekStatisticDomainModel> {
        val application = applicationsRepository.getAllApplications().firstOrNull {
            it.packageName == packageName
        }

        if (application == null) {
            return Either.Left(
                NoDataDomainError(),
            )
        }

        var beginTimeTemp = getBeginningOfDayTimestamp()
        var endTimeTemp = System.currentTimeMillis()

        var bar = mutableListOf<TimeUsageRepoModel?>()

        @Suppress("MagicNumber")
        repeat(7) {
            val foo = timeUsageRepository.getApplicationUsage(
                packageName = packageName,
                beginTime = beginTimeTemp,
                endTime = endTimeTemp,
            )
            StreamLog.streamLog {
                foo.toString()
            }
            bar.add(foo)
            endTimeTemp = beginTimeTemp
            beginTimeTemp -= TimeUnit.DAYS.toMillis(1)
        }
        bar.toString()
        return Either.Right(
            WeekStatisticDomainModel(
                // TODO: fix
                packageName,
                packageName,
                bar.map {
                    DayUsageStatisticDomainModel(
                        "foo",
                        it?.totalTimeInForeground ?: 0L,
                    )
                }.toSet(),
            ),
        )
    }
}
