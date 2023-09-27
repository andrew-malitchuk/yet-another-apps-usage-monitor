package dev.yaaum.common.core.ext

/**
 * Simple extension to fulfill binary multiplication
 */
infix fun Int.has(bit: Int) = this.and(bit) != 0
