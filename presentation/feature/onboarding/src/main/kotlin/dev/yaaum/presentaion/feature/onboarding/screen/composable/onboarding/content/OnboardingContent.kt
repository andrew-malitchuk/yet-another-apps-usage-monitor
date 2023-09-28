package dev.yaaum.presentaion.feature.onboarding.screen.composable.onboarding.content

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentaion.feature.onboarding.screen.OnboardingViewModel
import dev.yaaum.presentaion.feature.onboarding.screen.composable.onboarding.item.OnboardingItem
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumDefaultCircleButton
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumDefaultOrdinaryButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingContent(
    onboardingPages: List<OnboardingViewModel.OnboardingPage>,
    onInfoClick: (() -> Unit)? = null,
    onDoneClick: (() -> Unit)? = null,
) {
    val state = rememberPagerState(pageCount = {
        onboardingPages.size
    })
    val goToNextPageScope = rememberCoroutineScope()
    val buttonAlphaAnimation = animateFloatAsState(
        targetValue = if (state.currentPage == (state.pageCount - 1)) {
            1f
        } else {
            0f
        },
        label = "btn_letsgo",
    )

    Column(
        modifier = Modifier
            .background(YaaumTheme.colors.background)
            .fillMaxSize(),
    ) {
        HorizontalPager(
            state = state,
            modifier = Modifier
                .weight(1f, true),
        ) { page ->
            val currentPage = onboardingPages[page]
            OnboardingItem(
                image = currentPage.image,
                header = currentPage.header.asString(),
                caption = currentPage.caption.asString(),
                state = state,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(YaaumTheme.spacing.medium),
        ) {
            YaaumDefaultOrdinaryButton(
                modifier = Modifier
                    .weight(1f)
                    .alpha(buttonAlphaAnimation.value),
                text = "Next",
                onClick = {
                    if (state.currentPage == (state.pageCount - 1)) {
                        onDoneClick?.invoke()
                    }
                },
            )
            Spacer(modifier = Modifier.width(YaaumTheme.spacing.medium))
            YaaumDefaultCircleButton(
                modifier = Modifier,
                icon = if ((state.currentPage != (state.pageCount - 1))) {
                    ImageVector.vectorResource(R.drawable.icon_arrow_right_bold_24)
                } else {
                    ImageVector.vectorResource(R.drawable.icon_info_bold_24)
                },
                onClick = {
                    if (state.currentPage != (state.pageCount - 1)) {
                        goToNextPageScope.launch {
                            state.animateScrollToPage(state.currentPage + 1)
                        }
                    } else {
                        onInfoClick?.invoke()
                    }
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_OnboardingContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        OnboardingContent(
            onboardingPages = listOf(
                OnboardingViewModel.OnboardingPage(
                    R.drawable.illustration_call_waiting_1500,
                    UiText.DynamicString("foobar"),
                    UiText.DynamicString("foobar"),
                ),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_OnboardingContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        OnboardingContent(
            onboardingPages = listOf(
                OnboardingViewModel.OnboardingPage(
                    R.drawable.illustration_call_waiting_1500,
                    UiText.DynamicString("foobar"),
                    UiText.DynamicString("foobar"),
                ),
            ),
        )
    }
}
