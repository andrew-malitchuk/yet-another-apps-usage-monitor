package dev.yaaum.presentation.core.platform.mvi.timecapsule.impl

import dev.yaaum.presentation.core.platform.mvi.MviState
import dev.yaaum.presentation.core.platform.mvi.timecapsule.TimeCapsule

class TimeCapsuleImpl<S : MviState>(
    private val onStateSelected: (S) -> Unit,
) : TimeCapsule<S> {

    private val states = mutableListOf<S>()

    override fun addState(state: S) {
        states.add(state)
    }

    override fun selectState(position: Int) {
        onStateSelected(states[position])
    }

    override fun getStates(): List<S> {
        return states
    }
}
