package dev.yaaum.presentation.core.ui.composable.various

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun AnimatedDivider(
    modifier: Modifier = Modifier,
    state: ScrollableState,
    isInverted: Boolean = false,
) {
    val isVisible = if (isInverted) {
        state.canScrollForward
    } else {
        state.canScrollBackward
    }

    val currentWidth =
        LocalConfiguration.current.screenWidthDp

    val animatedDpValue by animateDpAsState(
        targetValue = if (isVisible) {
            currentWidth.dp
        } else {
            0.dp
        },
        label = "animatedDpValue",
    )

    val animatedAlpha by animateFloatAsState(
        targetValue = if (isVisible) 1.0f else 0f,
        label = "animatedAlpha",
    )

//
//    AnimatedVisibility(
//        visible = isVisible,
//    ) {
//        Divider(
//            modifier = modifier
//                .alpha(animatedAlpha),
//            thickness = animatedDpValue,
//            color = YaaumTheme.colors.surface,
//        )
//    }

    Divider(
        modifier = modifier
            .width(animatedDpValue)
            .alpha(animatedAlpha),
        thickness = YaaumTheme.dividers.extraSmall,
        color = YaaumTheme.colors.surface,
    )
}

@Preview(showBackground = true)
@Composable
fun Preview_AnimatedDivider_Light() {
    YaaumTheme(true) {
        AnimatedDivider(
            state = rememberLazyListState(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_AnimatedDivider_Dark() {
    YaaumTheme(false) {
        AnimatedDivider(
            state = rememberLazyListState(),
        )
    }
}
