package dev.yaaum.domain.core.error

import dev.yaaum.domain.core.error.base.BaseDomainError

class PermissionDomainError(
    override val message: String? = null,
    override val throwable: Throwable? = null,
) : BaseDomainError()
