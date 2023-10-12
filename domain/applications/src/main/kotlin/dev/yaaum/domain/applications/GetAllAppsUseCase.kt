package dev.yaaum.domain.applications

import arrow.core.Either
import dev.yaaum.domain.applications.model.ApplicationsDomainModel
import dev.yaaum.domain.core.error.base.BaseDomainError

interface GetAllAppsUseCase {
    suspend operator fun invoke(): Either<BaseDomainError, List<ApplicationsDomainModel>>
}
