package dev.yaaum.domain.configuration.impl

import arrow.core.Either
import dev.yaaum.data.repository.configuration.ConfigurationRepository
import dev.yaaum.domain.configuration.GetThemeUseCase
import dev.yaaum.domain.core.error.NoDataDomainError
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class GetThemeUseCaseImpl(
    private val configurationRepository: ConfigurationRepository,
) : GetThemeUseCase {

    override suspend fun invoke(): Either<BaseDomainError, String> {
        // TODO: add domain-level  wrapper for try-catch
        return try {
            configurationRepository.getCurrentConfiguration()?.themeMode?.run {
                Either.Right(this)
            } ?: run {
                Either.Left(
                    NoDataDomainError(),
                )
            }
        } catch (ex: Exception) {
            Either.Left(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
