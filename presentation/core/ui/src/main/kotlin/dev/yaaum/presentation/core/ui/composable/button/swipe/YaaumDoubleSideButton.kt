package dev.yaaum.presentation.core.ui.composable.button.swipe

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * Switch button
 *
 * @param modifier
 * @param sideA icon on the side A
 * @param sideB icon on the side B
 * @param onSideChange lambda
 */
// TODO doc
@Composable
fun YaaumDoubleSideButton(
    modifier: Modifier = Modifier,
    @DrawableRes
    sideA: Int,
    @DrawableRes
    sideB: Int,
    onSideChange: ((Boolean) -> Unit)? = null,
    defaultCorners: Dp = YaaumTheme.corners.medium,
    pressedCorners: Dp = YaaumTheme.corners.small,
    defaultBackgroundColor: Color = YaaumTheme.colors.secondary,
    pressedBackgroundColor: Color = YaaumTheme.colors.primary,
    defaultForegroundColor: Color = YaaumTheme.colors.onPrimary,
    pressedForegroundColor: Color = YaaumTheme.colors.onSecondary,
    contentSpacing: Dp = 0.dp,
) {
    var isPressed by remember {
        mutableStateOf(false)
    }

    val corner by animateFloatAsState(
        targetValue = if (isPressed) {
            pressedCorners.value
        } else {
            defaultCorners.value
        },
        label = "",
    )

    val backgroundColor by animateColorAsState(
        if (isPressed) {
            pressedBackgroundColor
        } else {
            defaultBackgroundColor
        },
        label = "",
    )

    val foregroundColor by animateColorAsState(
        if (isPressed) {
            pressedForegroundColor
        } else {
            defaultForegroundColor
        },
        label = "",
    )

    var onSideChangeState by remember {
        mutableStateOf(true)
    }
    Box(
        modifier = modifier
            .size(YaaumTheme.icons.extraMedium)
            .clip(RoundedCornerShape(corner.dp))
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {},
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        try {
                            isPressed = true
                            awaitRelease()
                        } finally {
                            isPressed = false
                            onSideChangeState = onSideChangeState.not()
                            onSideChange?.invoke(onSideChangeState)
                        }
                    },
                )
            }
            .padding(contentSpacing),

    ) {
        if (onSideChangeState) {
            Icon(
                painter = painterResource(id = sideA),
                contentDescription = null,
                tint = foregroundColor,
                modifier = Modifier
                    .align(Alignment.Center),
            )
        } else {
            Icon(
                painter = painterResource(id = sideB),
                contentDescription = null,
                tint = foregroundColor,
                modifier = Modifier
                    .align(Alignment.Center),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumDoubleSideButton_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumDoubleSideButton(
            sideA = R.drawable.icon_fire_bold_24,
            sideB = R.drawable.icon_plus_bold_24,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumDoubleSideButton_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumDoubleSideButton(
            sideA = R.drawable.icon_fire_bold_24,
            sideB = R.drawable.icon_plus_bold_24,
        )
    }
}
