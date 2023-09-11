package dev.yaaum.domain.core.error

import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * Something unpredictable. Used in case when exception happens on the domain layer or
 * when there is no suitable error for this case.
 */
data class SomethingHappensError(
    val message: String? = null,
    val exception: Exception? = null,
) : BaseDomainError()
