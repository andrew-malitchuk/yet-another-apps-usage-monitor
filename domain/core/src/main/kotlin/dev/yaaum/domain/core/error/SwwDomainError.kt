package dev.yaaum.domain.core.error

import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Something unpredictable. Used in case when exception happens on the domain layer or
 * when there is no suitable error for this case.
 */
data class SwwDomainError(
    override val message: String? = null,
    override val throwable: Throwable? = null,
) : BaseDomainError()
