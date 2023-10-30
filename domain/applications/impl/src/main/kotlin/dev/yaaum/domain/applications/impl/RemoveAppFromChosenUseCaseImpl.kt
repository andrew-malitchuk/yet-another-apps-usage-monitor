package dev.yaaum.domain.applications.impl

import arrow.core.raise.Raise
import dev.yaaum.data.repository.applications.ApplicationsRepository
import dev.yaaum.domain.applications.RemoveAppFromChosenUseCase
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.applications.model.toRepoModel
import dev.yaaum.domain.core.error.SomethingHappensError
import dev.yaaum.domain.core.error.base.BaseDomainError

class RemoveAppFromChosenUseCaseImpl(
    private val applicationsRepository: ApplicationsRepository,
) : RemoveAppFromChosenUseCase {

    context(Raise<BaseDomainError>)
    override suspend fun invoke(value: ApplicationsDomainModel) {
        try {
            applicationsRepository.apply {
                removeApplicationFromChosen(value.toRepoModel())
            }
        } catch (ex: Exception) {
            raise(
                SomethingHappensError(
                    exception = ex,
                ),
            )
        }
    }
}