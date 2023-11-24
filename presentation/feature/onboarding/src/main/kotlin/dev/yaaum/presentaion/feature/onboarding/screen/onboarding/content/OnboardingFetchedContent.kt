package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.content

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.item.OnboardingItem
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.OnboardingMvi
import dev.yaaum.presentaion.feature.onboarding.screen.onboarding.mvi.OnboardingMviState
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingFetchedContent(
    state: OnboardingMviState,
    onInfoClick: (() -> Unit)? = null,
    onDoneClick: (() -> Unit)? = null,
) {
    val pagerState = rememberPagerState(pageCount = {
        state.data.size
    })
    val goToNextPageScope = rememberCoroutineScope()
    val buttonAlphaAnimation = animateFloatAsState(
        targetValue = if (pagerState.currentPage == (pagerState.pageCount - 1)) {
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
            state = pagerState,
            modifier = Modifier
                .weight(1f, true),
        ) { page ->
            val currentPage = state.data[page]
            OnboardingItem(
                image = currentPage.image,
                header = currentPage.header.asString(),
                caption = currentPage.caption.asString(),
                state = pagerState,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(YaaumTheme.spacing.medium),
        ) {
            YaaumOrdinaryButton(
                title = "Next",
                modifier = Modifier
                    .weight(1f)
                    .alpha(buttonAlphaAnimation.value),
                defaultBackgroundColor = YaaumTheme.colors.primary,
                pressedBackgroundColor = YaaumTheme.colors.secondary,
                onClick = {
                    if (pagerState.currentPage == (pagerState.pageCount - 1)) {
                        onDoneClick?.invoke()
                    }
                },
            )
            Spacer(modifier = Modifier.width(YaaumTheme.spacing.medium))
            YaaumCircleButton(
                icon = if ((pagerState.currentPage != (pagerState.pageCount - 1))) {
                    R.drawable.icon_arrow_right_bold_24
                } else {
                    R.drawable.icon_info_bold_24
                },
                modifier = Modifier,
                defaultBackgroundColor = YaaumTheme.colors.primary,
                pressedBackgroundColor = YaaumTheme.colors.secondary,
                // TODO: fix
                iconSize = 24.dp,
                onClick = {
                    if (pagerState.currentPage != (pagerState.pageCount - 1)) {
                        goToNextPageScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
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
        OnboardingFetchedContent(
            state = OnboardingMviState(
                loading = false,
                data = listOf(
                    OnboardingMvi.OnboardingPage(
                        R.drawable.icon_fire_bold_24,
                        UiText.DynamicString("header1"),
                        UiText.DynamicString("caption1"),
                    ),
                    OnboardingMvi.OnboardingPage(
                        R.drawable.icon_fire_bold_24,
                        UiText.DynamicString("header2"),
                        UiText.DynamicString("caption2"),
                    ),
                    OnboardingMvi.OnboardingPage(
                        R.drawable.icon_fire_bold_24,
                        UiText.DynamicString("header3"),
                        UiText.DynamicString("caption3"),
                    ),
                ),
                error = null,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_OnboardingContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        OnboardingFetchedContent(
            state = OnboardingMviState(
                loading = false,
                data = listOf(
                    OnboardingMvi.OnboardingPage(
                        R.drawable.icon_fire_bold_24,
                        UiText.DynamicString("header1"),
                        UiText.DynamicString("caption1"),
                    ),
                    OnboardingMvi.OnboardingPage(
                        R.drawable.icon_fire_bold_24,
                        UiText.DynamicString("header2"),
                        UiText.DynamicString("caption2"),
                    ),
                    OnboardingMvi.OnboardingPage(
                        R.drawable.icon_fire_bold_24,
                        UiText.DynamicString("header3"),
                        UiText.DynamicString("caption3"),
                    ),
                ),
                error = null,
            ),
        )
    }
}