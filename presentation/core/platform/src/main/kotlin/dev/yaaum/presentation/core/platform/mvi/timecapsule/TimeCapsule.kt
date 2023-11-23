package dev.yaaum.presentation.core.platform.mvi.timecapsule

import dev.yaaum.presentation.core.platform.mvi.MviState

interface TimeCapsule<S : MviState> {
    fun addState(state: S)
    fun selectState(position: Int)
    fun getStates(): List<S>
}
