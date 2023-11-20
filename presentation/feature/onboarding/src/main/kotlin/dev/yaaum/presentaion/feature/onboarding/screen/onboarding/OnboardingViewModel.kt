package dev.yaaum.presentaion.feature.onboarding.screen.onboarding

import androidx.annotation.DrawableRes
import arrow.core.raise.recover
import dev.yaaum.domain.configuration.SetOnboardingFinishedUseCase
import dev.yaaum.presentaion.feature.onboarding.analytics.UserPassOnboardingAnalyticsEvent
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.platform.vm.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OnboardingViewModel(
    private val setOnboardingFinishedUseCase: SetOnboardingFinishedUseCase,
) : BaseViewModel() {

    var isConfigurationLoadingStateFlow: StateFlow<Boolean?> = MutableStateFlow(true)

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

    private fun logOnboardingFinish() {
        logEvent {
            UserPassOnboardingAnalyticsEvent()
        }
    }

    fun setOnboardingFinished() {
        launch(
            request = {
                recover({
                    setOnboardingFinishedUseCase(true)
                }, {
                })
            },
            result = {
                logOnboardingFinish()
            },
            loading = {
                isConfigurationLoadingStateFlow.setValue(it)
            },
            errorBlock = {
                isConfigurationLoadingStateFlow.setValue(false)
            },
        )
    }
}
