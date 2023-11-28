package dev.yaaum.presentation.core.ui.composable.item

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun YaaumBaseListContainer(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    defaultCorners: Dp = YaaumTheme.corners.medium,
    pressedCorners: Dp = YaaumTheme.corners.small,
    defaultBackgroundColor: Color = YaaumTheme.colors.surface,
    pressedBackgroundColor: Color = YaaumTheme.colors.surface,
    content: @Composable BoxScope.() -> Unit,
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

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(corner.dp))
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { },
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        try {
                            isPressed = true
                            awaitRelease()
                            onClick?.invoke()
                        } finally {
                            isPressed = false
                        }
                    },
                )
            },
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumBaseListContainer_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumBaseListContainer {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumBaseListContainer_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumBaseListContainer {
        }
    }
}
