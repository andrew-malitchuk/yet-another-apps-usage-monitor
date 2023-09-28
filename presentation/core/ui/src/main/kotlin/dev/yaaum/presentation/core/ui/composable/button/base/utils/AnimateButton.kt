package dev.yaaum.presentation.core.ui.composable.button.base.utils

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseInBack
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

/**
 * Perform button redraw via calling [drawButton]
 *
 * @param text button title; if `null` - title will be hidden
 * @param icon button icon; if `null` - icon will be hidden
 * @param backgroundColor
 * @param foregroundColor
 * @param borderColor
 * @param shape button shape
 * @param iconSize
 * @param borderSize
 * @param spacing space between [icon] and [text]
 * @param minWidth
 * @param minHeight
 * @param paddings
 * @param textStyle
 * @param animationDuration
 * @param animationEasing adjust an animation’s fraction
 * @param modifier
 */
@SuppressLint("ComposableNaming")
@Suppress("LongParameterList")
@Composable
fun animateButton(
    text: String?,
    icon: ImageVector?,
    backgroundColor: Color,
    foregroundColor: Color,
    borderColor: Color,
    shape: Shape,
    iconSize: Dp,
    borderSize: Dp,
    spacing: Dp,
    minWidth: Dp,
    minHeight: Dp,
    paddings: PaddingValues,
    textStyle: TextStyle?,
    animationDuration: Int,
    animationEasing: Easing,
    modifier: Modifier = Modifier,
) {
    val colorAnimationSpec =
        tween<Color>(durationMillis = animationDuration, easing = animationEasing)
    val animatedBorderColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = borderColor,
        label = "border",
    )
    val animatedBackgroundColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = backgroundColor,
        label = "background",
    )
    val animatedForegroundColor by animateColorAsState(
        animationSpec = colorAnimationSpec,
        targetValue = foregroundColor,
        label = "foreground",
    )

    val localModifier = modifier.animateContentSize(
        animationSpec = tween(
            durationMillis = animationDuration,
            easing = animationEasing,
        ),
    )
    drawButton(
        text = text,
        icon = icon,
        backgroundColor = animatedBackgroundColor,
        foregroundColor = animatedForegroundColor,
        borderColor = animatedBorderColor,
        shape = shape,
        iconSize = iconSize,
        borderSize = borderSize,
        spacing = spacing,
        minWidth = minWidth,
        minHeight = minHeight,
        paddings = paddings,
        textStyle = textStyle,
        modifier = localModifier,
    )
}

@SuppressLint("ComposableNaming")
@Preview(showBackground = true)
@Composable
internal fun Preview_animateButton_Dark() {
    YaaumTheme(useDarkTheme = true) {
        animateButton(
            text = "Button",
            icon = Icons.Default.AccountCircle,
            backgroundColor = Color.White,
            foregroundColor = Color.Black,
            borderColor = Color.Black,
            shape = CutCornerShape(topEndPercent = 30, bottomStartPercent = 30),
            iconSize = 32.dp,
            borderSize = 3.dp,
            spacing = 8.dp,
            minWidth = 60.dp,
            minHeight = 48.dp,
            paddings = PaddingValues(all = 32.dp),
            textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
            animationDuration = 250,
            animationEasing = EaseInBack,
        )
    }
}

@SuppressLint("ComposableNaming")
@Preview(showBackground = true)
@Composable
internal fun Preview_animateButton_Light() {
    YaaumTheme(useDarkTheme = false) {
        animateButton(
            text = "Button",
            icon = Icons.Default.AccountCircle,
            backgroundColor = Color.White,
            foregroundColor = Color.Black,
            borderColor = Color.Black,
            shape = CutCornerShape(topEndPercent = 30, bottomStartPercent = 30),
            iconSize = 32.dp,
            borderSize = 3.dp,
            spacing = 8.dp,
            minWidth = 60.dp,
            minHeight = 48.dp,
            paddings = PaddingValues(all = 32.dp),
            textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
            animationDuration = 250,
            animationEasing = EaseInBack,
        )
    }
}
