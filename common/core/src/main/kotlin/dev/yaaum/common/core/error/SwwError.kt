package dev.yaaum.common.core.error

import dev.yaaum.common.core.error.base.BaseError

data class SwwError(
    val throwable: Throwable,
    val message: String? = null,
) : BaseError
