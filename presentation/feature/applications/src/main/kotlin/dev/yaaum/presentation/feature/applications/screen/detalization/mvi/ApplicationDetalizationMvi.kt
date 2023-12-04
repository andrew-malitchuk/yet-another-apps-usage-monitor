package dev.yaaum.presentation.feature.applications.screen.detalization.mvi

import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("Unused", "UnusedPrivateProperty")
class ApplicationDetalizationMvi :
    BaseMvi<ApplicationDetalizationMviState, ApplicationDetalizationMviEvent, ApplicationDetalizationMviEffect>() {

    override val state: StateFlow<ApplicationDetalizationMviState>
        get() = reducer.state

    override val effect: SharedFlow<ApplicationDetalizationMviEffect?> = MutableSharedFlow()

    override val reducer =
        ApplicationDetalizationMviReducer(ApplicationDetalizationMviState.initial())
}
