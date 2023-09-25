package dev.yaaum.common.core.ext

infix fun Int.has(bit: Int) = this.and(bit) != 0
