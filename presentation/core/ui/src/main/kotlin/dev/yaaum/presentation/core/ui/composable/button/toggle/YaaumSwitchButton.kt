package dev.yaaum.presentation.core.ui.composable.button.toggle

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * Switch button
 *
 * @param modifier
 * @param width
 * @param height
 * @param checkedTrackColor
 * @param uncheckedTrackColor
 * @param gapBetweenThumbAndTrackEdge
 * @param borderWidth
 * @param cornerSize
 * @param iconInnerPadding
 * @param thumbSize
 * @param initValue
 */
@Composable
fun YaaumSwitchButton(
    modifier: Modifier = Modifier,
    width: Dp = 72.dp,
    height: Dp = 40.dp,
    checkedTrackColor: Color = YaaumTheme.colors.primary,
    uncheckedTrackColor: Color = YaaumTheme.colors.secondary,
    gapBetweenThumbAndTrackEdge: Dp = YaaumTheme.spacing.small,
    borderWidth: Dp = YaaumTheme.dividers.extraSmall,
    cornerSize: Int = 50,
    iconInnerPadding: Dp = YaaumTheme.spacing.extraSmall,
    // TODO: fix
    thumbSize: Dp = 24.dp,
    initValue: Boolean = false,
    onStateChange: ((Boolean) -> Unit)? = null,
    foo: Boolean? = null,
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    var onSideChangeState by remember {
        mutableStateOf(initValue)
    }

    if (foo != null && foo != onSideChangeState) {
        onSideChangeState = foo
    }

    val alignment by animateAlignmentAsState(if (onSideChangeState) 1f else -1f)
    Box(
        modifier = modifier
            .size(width = width, height = height)
            .border(
                width = borderWidth,
                color = if (onSideChangeState) checkedTrackColor else uncheckedTrackColor,
                shape = RoundedCornerShape(percent = cornerSize),
            )
            .clickable(
                indication = null,
                interactionSource = interactionSource,
            ) {
                onSideChangeState = onSideChangeState.not()
                onStateChange?.invoke(onSideChangeState)
            },
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .padding(
                    start = gapBetweenThumbAndTrackEdge,
                    end = gapBetweenThumbAndTrackEdge,
                )
                .fillMaxSize(),
            contentAlignment = alignment,
        ) {
            Box(
                modifier = Modifier
                    .size(size = thumbSize)
                    .background(
                        color = if (onSideChangeState) checkedTrackColor else uncheckedTrackColor,
                        shape = CircleShape,
                    )
                    .padding(all = iconInnerPadding),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumSwitchButton_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumSwitchButton()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumSwitchButton_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumSwitchButton()
    }
}

// TODO: move me
@Composable
private fun animateAlignmentAsState(
    targetBiasValue: Float,
): State<BiasAlignment> {
    val bias by animateFloatAsState(targetBiasValue, label = "")
    return remember { derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) } }
}
