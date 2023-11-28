package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.annotation.DrawableRes
import arrow.core.raise.recover
import dev.yaaum.domain.configuration.SetOnboardingFinishedUseCase
import dev.yaaum.presentaion.feature.onboarding.analytics.UserPassOnboardingAnalyticsEvent
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.error.SwwUiError
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

    override fun innerEventProcessing(event: OnboardingMviEvent) {
        when (event) {
            // TODO: fix
            is OnboardingMviEvent.GetPagesMviEvent -> Unit
            OnboardingMviEvent.OnDoneMviEvent -> setOnboardingFinished()
        }
    }

    private fun logOnboardingFinish() {
        logEvent {
            UserPassOnboardingAnalyticsEvent()
        }
    }

    private fun setOnboardingFinished() {
        launch(
            request = {
                // TODO: fix this ugly
                recover(
                    {
                        setOnboardingFinishedUseCase(true)
                        logOnboardingFinish()
                        sendEffect(OnboardingMviEffect.GoToMainScreenMviEffect)
                    },
                    {
                        reducer.setState(
                            OnboardingMviState.error(
                                // TODO: fix me
                                SwwUiError(
                                    UiText.DynamicString(it.message ?: ""),
                                    it.throwable,
                                ),
                            ),
                        )
                    },
                )
            },
            errorBlock = {
                reducer.setState(
                    OnboardingMviState.error(
                        // TODO: fix me
                        SwwUiError(
                            UiText.DynamicString(it.message ?: ""),
                            it,
                        ),
                    ),
                )
            },
        )
    }

    /**
     * Onboarding pages
     */
    private var onboardingPages = listOf(
        OnboardingPage(
            R.drawable.icon_fire_bold_24,
            UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.onboarding_page_1_title),
            UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.onboarding_page_1_description),
        ),
        OnboardingPage(
            R.drawable.icon_battery_charging_bold_24,
            UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.onboarding_page_2_title),
            UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.onboarding_page_2_description),
        ),
        OnboardingPage(
            R.drawable.icon_calendar_bold_24,
            UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.onboarding_page_3_title),
            UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.onboarding_page_3_description),
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
