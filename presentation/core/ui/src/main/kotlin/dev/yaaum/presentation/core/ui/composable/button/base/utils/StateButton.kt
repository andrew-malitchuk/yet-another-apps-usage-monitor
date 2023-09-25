package dev.yaaum.presentation.core.ui.composable.button.base.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonAnimation
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonColors
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonSizes
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonState

@SuppressLint("ComposableNaming")
@Composable
fun stateButton(
    text: String?,
    onClick: () -> Unit,
    icon: ImageVector?,
    colors: YaaumButtonColors,
    sizes: YaaumButtonSizes,
    shape: Shape,
    textStyle: TextStyle?,
    animation: YaaumButtonAnimation,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()

    var interactionState = 0
    if (isHovered) interactionState = interactionState.or(YaaumButtonState.HOVER)
    if (isPressed) interactionState = interactionState.or(YaaumButtonState.PRESSED)
    if (isFocused) interactionState = interactionState.or(YaaumButtonState.FOCUSED)

    val currentModifier = modifier.clickable(
        interactionSource = interactionSource,
        indication = null,
        enabled = enabled,
        onClick = onClick,
        role = Role.Button,
    )

    val backgroundColor = colors.backgroundColor(interactionState, enabled).value
    val foregroundColor = colors.foregroundColor(interactionState, enabled).value
    val borderColor = colors.borderColor(interactionState, enabled).value

    animateButton(
        text = text,
        icon = icon,
        backgroundColor = backgroundColor,
        foregroundColor = foregroundColor,
        borderColor = borderColor,
        shape = shape,
        iconSize = sizes.iconSize,
        borderSize = sizes.borderSize,
        spacing = sizes.spacing,
        minWidth = sizes.minWidth,
        minHeight = sizes.minHeight,
        paddings = sizes.contentPadding,
        textStyle = textStyle,
        animationDuration = animation.duration,
        animationEasing = animation.easing,
        modifier = currentModifier,
    )
}
