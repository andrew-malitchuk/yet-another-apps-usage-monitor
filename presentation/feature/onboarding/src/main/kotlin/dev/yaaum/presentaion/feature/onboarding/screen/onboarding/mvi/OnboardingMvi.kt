package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.annotation.DrawableRes
import dev.yaaum.domain.configuration.SetOnboardingFinishedUseCase
import dev.yaaum.presentaion.feature.onboarding.analytics.UserPassOnboardingAnalyticsEvent
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.ui.R
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("UnusedPrivateMember")
class OnboardingMvi(
    private val setOnboardingFinishedUseCase: SetOnboardingFinishedUseCase,
) : BaseMvi<OnboardingMviState, OnboardingMviEvent, OnboardingMviEffect>() {

    override val state: StateFlow<OnboardingMviState>
        get() = reducer.state

    override val effect: SharedFlow<OnboardingMviEffect?> = MutableSharedFlow()

    override val reducer = OnboardingReducer(OnboardingMviState.initial())

    override fun innerEffectProcessing(effect: OnboardingMviEffect) {
        when (effect) {
            OnboardingMviEffect.GoToMainScreenMviEffect -> logOnboardingFinish()
        }
    }

    private fun logOnboardingFinish() {
        logEvent {
            UserPassOnboardingAnalyticsEvent()
        }
    }

    /**
     * Onboarding pages
     */
    private var onboardingPages = listOf(
        OnboardingPage(
            R.drawable.icon_fire_bold_24,
            UiText.DynamicString("header1"),
            UiText.DynamicString("caption1"),
        ),
        OnboardingPage(
            R.drawable.icon_fire_bold_24,
            UiText.DynamicString("header2"),
            UiText.DynamicString("caption2"),
        ),
        OnboardingPage(
            R.drawable.icon_fire_bold_24,
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

    init {
        sendEvent(OnboardingMviEvent.GetPagesMviEvent(data = onboardingPages))
    }
}
