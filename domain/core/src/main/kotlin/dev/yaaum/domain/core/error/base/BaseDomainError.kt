package dev.yaaum.domain.core.error.base

import dev.yaaum.common.core.error.base.BaseError

/**
 * Base class for :domain level errors
 */
abstract class BaseDomainError : BaseError {
    abstract val message: String?
    abstract val throwable: Throwable?
}
