package dev.yaaum.presentaion.feature.onboarding.screen

import androidx.annotation.DrawableRes
import dev.yaaum.feature.onboarding.R
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.platform.viewmodel.BaseViewModel

class OnboardingViewModel : BaseViewModel() {

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
