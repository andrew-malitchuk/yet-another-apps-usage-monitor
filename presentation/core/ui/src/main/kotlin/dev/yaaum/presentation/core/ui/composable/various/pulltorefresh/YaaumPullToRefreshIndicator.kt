package dev.yaaum.presentation.core.ui.composable.various.pulltorefresh

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.loader.YaaumLoader
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import kotlin.math.abs
import kotlin.math.roundToInt

@Suppress("OptionalWhenBraces", "MagicNumber", "LongMethod")
@Composable
fun YaaumPullToRefreshIndicator(
    modifier: Modifier = Modifier,
    indicatorState: YaaumRefreshIndicatorState,
    pullToRefreshProgress: Float,
    timeElapsed: String,
) {
    var fling = if (pullToRefreshProgress < 0) {
        1f
    } else if (pullToRefreshProgress > 0 && pullToRefreshProgress <= 1) {
        (1 - abs(pullToRefreshProgress))
    } else {
        1f
    }
    var alpha = 1f
    val maxHeight = 100
    val maxHeightDivider = 2
    val heightModifier: Modifier
    val dividerHeight: Modifier
    when (indicatorState) {
        YaaumRefreshIndicatorState.PullingDown -> {
            heightModifier = Modifier.height(
                (pullToRefreshProgress * 100)
                    .roundToInt()
                    .coerceAtMost(maxHeight).dp,
            )
            dividerHeight = Modifier.height(
                (pullToRefreshProgress * 100)
                    .roundToInt()
                    .coerceAtMost(maxHeightDivider).dp,
            )
            alpha = (0 + abs(pullToRefreshProgress))
        }

        YaaumRefreshIndicatorState.ReachedThreshold -> {
            fling = 0f
            heightModifier = Modifier.height(maxHeight.dp)
            dividerHeight = Modifier.height(maxHeightDivider.dp)
            alpha = 1f
        }

        YaaumRefreshIndicatorState.Refreshing -> {
            fling = 0f
            heightModifier = Modifier.wrapContentHeight()
            dividerHeight = Modifier.height(maxHeightDivider.dp)
            alpha = 1f
        }

        YaaumRefreshIndicatorState.Default -> {
            fling = 1f
            heightModifier = Modifier.height(0.dp)
            dividerHeight = Modifier.height(0.dp)
            alpha = 0f
        }
    }
    val currentWidth =
        LocalConfiguration.current.screenWidthDp - (LocalConfiguration.current.screenWidthDp * fling)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background),
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .animateContentSize()
                .then(heightModifier),
            contentAlignment = Alignment.BottomStart,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(alpha),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(YaaumTheme.spacing.small),
            ) {
                Spacer(modifier = Modifier.height(YaaumTheme.spacing.small))
                Text(
                    text = indicatorState.message,
                    style = YaaumTheme.typography.title,
                    color = YaaumTheme.colors.primary,
                )
                if (indicatorState == YaaumRefreshIndicatorState.Refreshing) {
                    YaaumLoader()
                } else {
                    Text(
                        text = "last update: $timeElapsed",
                        style = YaaumTheme.typography.caption,
                        color = YaaumTheme.colors.primary,
                    )
                }
                Spacer(modifier = Modifier.height(YaaumTheme.spacing.small))
            }
        }
        Divider(
            modifier = Modifier
                .width(currentWidth.dp)
                .align(Alignment.CenterHorizontally)
                .then(dividerHeight),
            thickness = YaaumTheme.dividers.extraSmall,
            color = YaaumTheme.colors.surface,
        )
    }
}
