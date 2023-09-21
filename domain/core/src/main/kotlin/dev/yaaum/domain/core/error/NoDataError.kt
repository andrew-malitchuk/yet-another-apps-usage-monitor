package dev.yaaum.domain.core.error

import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * There is nothing to pass. No data case.
 */
data class NoDataError(
    val message: String? = null,
) : BaseDomainError()
