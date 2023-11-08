package dev.yaaum.presentation.core.ui.composable.various.pulltorefresh

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import kotlin.math.roundToInt

@Composable
fun YaaumPullToRefreshIndicator(
    modifier: Modifier = Modifier,
    indicatorState: YaaumRefreshIndicatorState,
    pullToRefreshProgress: Float,
    timeElapsed: String,
) {
    @Suppress("MagicNumber")
    val maxHeight = 100

    @Suppress("OptionalWhenBraces", "MagicNumber")
    val heightModifier = when (indicatorState) {
        YaaumRefreshIndicatorState.PullingDown -> {
            Modifier.height(
                (pullToRefreshProgress * 100)
                    .roundToInt()
                    .coerceAtMost(maxHeight).dp,
            )
        }

        YaaumRefreshIndicatorState.ReachedThreshold -> Modifier.height(maxHeight.dp)
        YaaumRefreshIndicatorState.Refreshing -> Modifier.wrapContentHeight()
        YaaumRefreshIndicatorState.Default -> Modifier.height(0.dp)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
            .then(heightModifier)
            .padding(15.dp),
        contentAlignment = Alignment.BottomStart,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
//                text = stringResource(indicatorState.messageRes),
                text = indicatorState.message,
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.primary,
            )
            if (indicatorState == YaaumRefreshIndicatorState.Refreshing) {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    color = YaaumTheme.colors.primary,
                    strokeWidth = 2.dp,
                )
            } else {
                Text(
//                    text = stringResource(R.string.last_updated, timeElapsed),
                    text = "last update: $timeElapsed",
                    style = YaaumTheme.typography.caption,
                    color = YaaumTheme.colors.primary,
                )
            }
        }
    }
}
