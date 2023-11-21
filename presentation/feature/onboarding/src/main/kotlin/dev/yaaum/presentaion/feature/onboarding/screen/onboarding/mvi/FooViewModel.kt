package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.annotation.DrawableRes
import dev.yaaum.domain.configuration.SetOnboardingFinishedUseCase
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.platform.vm.UnidirectionalViewModel

class FooViewModel(
    @Suppress("UnusedPrivateProperty")
    private val setOnboardingFinishedUseCase: SetOnboardingFinishedUseCase,
) :
    UnidirectionalViewModel<OnboardingState<List<FooViewModel.OnboardingPage>>, OnboardingEvent, OnboardingEffect>() {

    override fun createInitialState(): OnboardingState<List<OnboardingPage>> {
        return OnboardingState()
    }

    override fun handleEvent(event: OnboardingEvent) = Unit

    //region
    /**
     * Onboarding pages
     */
    @Suppress("UnusedPrivateProperty")
    private var onboardingPages = listOf(
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
    //endregion
}
