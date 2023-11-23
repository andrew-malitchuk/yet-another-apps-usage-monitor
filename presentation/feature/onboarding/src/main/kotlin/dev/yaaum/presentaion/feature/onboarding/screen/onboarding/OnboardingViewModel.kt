package dev.yaaum.presentaion.feature.onboarding.screen.onboarding

import arrow.core.raise.recover
import dev.yaaum.domain.configuration.SetOnboardingFinishedUseCase
import dev.yaaum.presentaion.feature.onboarding.analytics.UserPassOnboardingAnalyticsEvent
import dev.yaaum.presentation.core.platform.vm.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OnboardingViewModel(
    private val setOnboardingFinishedUseCase: SetOnboardingFinishedUseCase,
) : BaseViewModel() {

    var isConfigurationLoadingStateFlow: StateFlow<Boolean?> = MutableStateFlow(true)

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
