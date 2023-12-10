package dev.yaaum.presentation.core.ui.composable.ext

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.various.placeholder.PlaceholderHighlight
import dev.yaaum.presentation.core.ui.composable.various.placeholder.placeholder
import dev.yaaum.presentation.core.ui.composable.various.placeholder.shimmer

/**
 * Remove focus from keyboard
 */
@OptIn(ExperimentalLayoutApi::class)
fun Modifier.clearFocusOnKeyboardDismiss(): Modifier = composed {
    var isFocused by remember { mutableStateOf(false) }
    var keyboardAppearedSinceLastFocused by remember { mutableStateOf(false) }
    if (isFocused) {
        val imeIsVisible = WindowInsets.isImeVisible
        val focusManager = LocalFocusManager.current
        LaunchedEffect(imeIsVisible) {
            if (imeIsVisible) {
                keyboardAppearedSinceLastFocused = true
            } else if (keyboardAppearedSinceLastFocused) {
                focusManager.clearFocus()
            }
        }
    }
    onFocusEvent {
        if (isFocused != it.isFocused) {
            isFocused = it.isFocused
            if (isFocused) {
                keyboardAppearedSinceLastFocused = false
            }
        }
    }
}

/**
 *
 */
fun Modifier.shimmerEffect(
    duration: Int = 1_000,
    shape: Shape,
): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition(
        label = "Animates the background",
    )
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(duration),
        ),
        label = "Animates the background",
    )
    @Suppress("MagicNumber")
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB8B5B5),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5),
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat()),
        ),
        shape = shape,
    )
        .onGloballyPositioned {
            size = it.size
        }
}

@Suppress("MagicNumber")
fun Modifier.placeholder(
    isLoading: Boolean,
    backgroundColor: Color = Color.Unspecified,
    shape: Shape = RoundedCornerShape(4.dp),
    showShimmerAnimation: Boolean = true,
): Modifier = composed {
    val highlight = if (showShimmerAnimation) {
        PlaceholderHighlight.shimmer(highlightColor = MaterialTheme.colorScheme.onTertiary)
    } else {
        null
    }
    val specifiedBackgroundColor = backgroundColor.takeOrElse { Color(0xFFDBD6D1).copy(0.6f) }
    Modifier.placeholder(
        color = specifiedBackgroundColor,
        visible = isLoading,
        shape = shape,
        highlight = highlight,
    )
}
