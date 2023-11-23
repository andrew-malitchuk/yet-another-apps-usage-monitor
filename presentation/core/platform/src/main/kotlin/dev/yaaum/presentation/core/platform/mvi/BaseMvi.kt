package dev.yaaum.presentation.core.platform.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

abstract class BaseMvi<STATE : MviState, in EVENT : MviEvent, EFFECT : MviEffect> : ViewModel() {

    abstract val state: Flow<STATE>

    abstract val effect: Flow<EFFECT?>
}
