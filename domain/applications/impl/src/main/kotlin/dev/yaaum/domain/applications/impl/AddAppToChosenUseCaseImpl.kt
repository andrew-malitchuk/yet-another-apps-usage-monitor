package dev.yaaum.domain.applications.impl

import arrow.core.raise.Raise
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.domain.applications.AddAppToChosenUseCase
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.applications.model.toRepoModel
import dev.yaaum.domain.core.error.SwwDomainError
import dev.yaaum.domain.core.error.base.BaseDomainError

class AddAppToChosenUseCaseImpl(
    private val applicationsRepository: ApplicationsRepository,
) : AddAppToChosenUseCase {

    context(Raise<BaseDomainError>)
    override suspend fun invoke(value: ApplicationsDomainModel) {
        try {
            applicationsRepository.apply {
                markApplicationAsChosen(value.toRepoModel())
            }
        } catch (ex: Exception) {
            raise(
                SwwDomainError(
                    throwable = ex,
                ),
            )
        }
    }
}
