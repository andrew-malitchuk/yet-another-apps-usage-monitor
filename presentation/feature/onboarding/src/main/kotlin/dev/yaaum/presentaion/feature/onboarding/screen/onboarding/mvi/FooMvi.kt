package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.annotation.DrawableRes
import androidx.lifecycle.viewModelScope
import dev.yaaum.domain.configuration.SetOnboardingFinishedUseCase
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.OnboardingViewModel
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.platform.mvi.timecapsule.TimeCapsule
import dev.yaaum.presentation.core.ui.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@Suppress("UnusedPrivateMember")
class FooMvi(
    private val setOnboardingFinishedUseCase: SetOnboardingFinishedUseCase,
) : BaseMvi<OnboardingMviState, OnboardingMviEvent, OnboardingMviEffect>() {

    private val reducer = OnboardingReducer(OnboardingMviState.initial())

    override val state: StateFlow<OnboardingMviState>
        get() = reducer.state

    override val effect: Flow<OnboardingMviEffect?> = MutableSharedFlow()

    val timeMachine: TimeCapsule<OnboardingMviState>
        get() = reducer.timeCapsule

    init {
        viewModelScope.launch(Dispatchers.Default) {
            val data = listOf(
                OnboardingViewModel.OnboardingPage(
                    R.drawable.icon_fire_bold_24,
                    UiText.DynamicString("header1"),
                    UiText.DynamicString("caption1"),
                ),
                OnboardingViewModel.OnboardingPage(
                    R.drawable.icon_fire_bold_24,
                    UiText.DynamicString("header2"),
                    UiText.DynamicString("caption2"),
                ),
                OnboardingViewModel.OnboardingPage(
                    R.drawable.icon_fire_bold_24,
                    UiText.DynamicString("header3"),
                    UiText.DynamicString("caption3"),
                ),
            )
            sendEvent(OnboardingMviEvent.GetPagesMviEvent(data = data))
        }
    }

    private fun sendEvent(event: OnboardingMviEvent) {
        reducer.sendEvent(event)
    }

    fun sendEffect(effect: OnboardingMviEffect) {
        viewModelScope.launch {
            (this@FooMvi.effect as? MutableSharedFlow)?.emit(
                effect,
            )
        }
    }

//    private fun logOnboardingFinish() {
//        logEvent {
//            UserPassOnboardingAnalyticsEvent()
//        }
//    }

    /**
     * Onboarding pages
     */
    var onboardingPages = listOf(
        OnboardingPage(
            dev.yaaum.presentation.core.ui.R.drawable.icon_fire_bold_24,
            UiText.DynamicString("header1"),
            UiText.DynamicString("caption1"),
        ),
        OnboardingPage(
            dev.yaaum.presentation.core.ui.R.drawable.icon_fire_bold_24,
            UiText.DynamicString("header2"),
            UiText.DynamicString("caption2"),
        ),
        OnboardingPage(
            dev.yaaum.presentation.core.ui.R.drawable.icon_fire_bold_24,
            UiText.DynamicString("header3"),
            UiText.DynamicString("caption3"),
        ),
    )

    data class OnboardingPage(
        @DrawableRes
        val image: Int,
        val header: UiText,
        val caption: UiText,
    )
}
