package dev.yaaum.presentation.core.ui.composable.indicator

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Suppress("MagicNumber")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun YaaumPageIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    indicatorColor: Color = YaaumTheme.colors.primary,
    spacing: Dp = 4.dp,
    height: Dp = 8.dp,
    selectPageMultiplier: Int = 2,
) {
    Row(
        modifier = modifier
            .wrapContentSize(),
    ) {
        val offsetIntPart = pagerState.currentPageOffsetFraction.toInt()
        val offsetFractionalPart = pagerState.currentPageOffsetFraction - offsetIntPart
        val currentPage = pagerState.currentPage + offsetIntPart
        val targetPage =
            if (pagerState.currentPageOffsetFraction < 0) currentPage - 1 else currentPage + 1
        val currentPageWidth =
            height * (1 + (1 - kotlin.math.abs(offsetFractionalPart)) * selectPageMultiplier)
        val targetPageWidth = height * (1 + kotlin.math.abs(offsetFractionalPart) * selectPageMultiplier)

        repeat(pagerState.pageCount) { index ->
            val width = when (index) {
                currentPage -> currentPageWidth
                targetPage -> targetPageWidth
                else -> height
            }
            Box(
                modifier = Modifier
                    .width(animateDpAsState(targetValue = width, label = "").value)
                    .width(width)
                    .clip(RoundedCornerShape(50))
                    .height(height)
                    .background(indicatorColor),
            )
            if (index != pagerState.pageCount - 1) {
                Spacer(modifier = Modifier.width(spacing))
            }
        }
    }
}

@Suppress("MagicNumber")
@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun Preview_YaaumPageIndicator_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumPageIndicator(
            pagerState = rememberPagerState {
                10
            },
        )
    }
}

@Suppress("MagicNumber")
@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun Preview_YaaumPageIndicator_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumPageIndicator(
            pagerState = rememberPagerState {
                10
            },
        )
    }
}
