package dev.yaaum.domain.core.error

import dev.yaaum.domain.core.error.base.BaseDomainError

/**
 * There is nothing to pass. No data case.
 */
data class NoDataDomainError(
    override val message: String? = null,
    override val throwable: Throwable? = null,
) : BaseDomainError()
