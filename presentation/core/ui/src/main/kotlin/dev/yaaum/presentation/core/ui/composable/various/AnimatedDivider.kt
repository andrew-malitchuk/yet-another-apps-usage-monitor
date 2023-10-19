package dev.yaaum.presentation.core.ui.composable.various

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun AnimatedDivider(
    modifier: Modifier = Modifier,
    state: LazyListState,
    isInverted: Boolean = false,
) {
//    val isVisible = (state.canScrollBackward && !isInverted)
    val isVisible = if (isInverted) {
        state.canScrollForward
    } else {
        state.canScrollBackward
    }

    val animatedDpValue by animateDpAsState(
        targetValue = if (isVisible) {
            YaaumTheme.dividers.extraSmall
        } else {
            0.dp
        },
        label = "animatedDpValue",
    )

    val animatedAlpha by animateFloatAsState(
        targetValue = if (isVisible) 1.0f else 0f,
        label = "animatedAlpha",
    )

    AnimatedVisibility(
        visible = isVisible,
    ) {
        Divider(
            modifier = modifier
                .alpha(animatedAlpha),
            thickness = animatedDpValue,
            color = YaaumTheme.colors.surface,
        )
    }
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