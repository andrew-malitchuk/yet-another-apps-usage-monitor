package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi

import androidx.annotation.DrawableRes
import dev.yaaum.domain.configuration.SetOnboardingFinishedUseCase
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.platform.vm.UnidirectionalViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class FooViewModel(
    @Suppress("UnusedPrivateProperty")
    private val setOnboardingFinishedUseCase: SetOnboardingFinishedUseCase,
) :
    UnidirectionalViewModel<OnboardingState, OnboardingIntent, OnboardingEffect>() {

    override val state: StateFlow<OnboardingState> = MutableStateFlow(OnboardingLoading())

    override val effect: SharedFlow<OnboardingEffect> = MutableSharedFlow()

    override fun load() {
        event(
            OnboardingIntent.GetOnboardingPagesIntent,
        )
    }

    override fun event(event: OnboardingIntent) {
        @Suppress("OptionalWhenBraces")
        when (event) {
            is OnboardingIntent.GetOnboardingPagesIntent -> {
                getOnboardingPages()
            }
        }
    }

    private fun getOnboardingPages() {
        call(
            request = {
                @Suppress("MagicNumber")
                delay(5_000L)
                state.setValue(
                    OnboardingFetched(
                        content = onboardingPages,
                    ),
                )
            },
        )
    }

    //
    /**
     * Onboarding pages
     */
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
    //
}
