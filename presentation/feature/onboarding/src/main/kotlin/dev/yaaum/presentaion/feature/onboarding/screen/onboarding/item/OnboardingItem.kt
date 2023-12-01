package dev.yaaum.presentaion.feature.onboarding.screen.onboarding.item

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import kotlin.math.abs

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Suppress("MagicNumber")
fun OnboardingItem(
    @DrawableRes
    image: Int,
    header: String,
    caption: String,
    state: PagerState,
) {
    val position = state.currentPageOffsetFraction
    val scaleMultiplier = 0.25
    val minScale = 0.75
    val scaleValue = if (position < 0) {
        (((minScale - (-position) * scaleMultiplier).toFloat() + scaleMultiplier).toFloat())
    } else if (position > 0 && position <= 1) {
        (((minScale - position * scaleMultiplier).toFloat() + scaleMultiplier).toFloat())
    } else {
        1f
    }
    val alphaValue = if (position < 0) {
        (1 - abs(position))
    } else if (position > 0 && position <= 1) {
        (1 - position)
    } else {
        1f
    }

    val cornerValue = if (position < 0) {
        (1 - abs(position))
    } else if (position > 0 && position <= 1) {
        (1 - position)
    } else {
        1f
    }

    val corner = YaaumTheme.corners.extraLarge - (YaaumTheme.corners.extraLarge * abs(cornerValue))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .scale(scaleValue)
            .clip(RoundedCornerShape(size = corner))
            .background(YaaumTheme.colors.surface)
            .padding(YaaumTheme.spacing.medium),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(
                        YaaumTheme.spacing.large,
                    )
                    .scale(scaleValue)
                    .alpha(alphaValue),
                colorFilter = ColorFilter.tint(YaaumTheme.colors.primary),
                contentScale = ContentScale.Fit,
            )
            Spacer(
                modifier = Modifier.height(YaaumTheme.spacing.medium),
            )
            Column(
                modifier = Modifier,
            ) {
                Text(
                    text = header,
                    style = YaaumTheme.typography.display,
                    modifier = Modifier.alpha(alphaValue),
                    color = YaaumTheme.colors.onSurface,
                )
                Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
                Text(
                    text = caption,
                    style = YaaumTheme.typography.title,
                    modifier = Modifier.alpha(alphaValue),
                    color = YaaumTheme.colors.onSurface,
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun Preview_OnboardingItem_Dark() {
    YaaumTheme(useDarkTheme = true) {
        OnboardingItem(
            dev.yaaum.presentation.core.ui.R.drawable.icon_fire_bold_24,
            "header",
            "caption",
            rememberPagerState {
                1
            },
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun Preview_OnboardingItem_Light() {
    YaaumTheme(useDarkTheme = false) {
        OnboardingItem(
            dev.yaaum.presentation.core.ui.R.drawable.icon_fire_bold_24,
            "header",
            "caption",
            rememberPagerState {
                1
            },
        )
    }
}
