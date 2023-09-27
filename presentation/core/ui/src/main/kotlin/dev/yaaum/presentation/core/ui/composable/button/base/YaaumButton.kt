@file:Suppress("MagicNumber")

package dev.yaaum.presentation.core.ui.composable.button.base

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import dev.yaaum.presentation.core.ui.composable.button.base.utils.stateButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

/**
 * Top of the button hierarchy.
 *
 * Used for __circle__ and __ordinary__ buttons
 *
 * @param text
 * @param onClick
 * @param modifier
 * @param icon
 * @param enabled
 * @param colors
 * @param sizes
 * @param shape
 * @param textStyle
 * @param animation
 * @param interactionSource
 *
 * [source](https://proandroiddev.com/compose-a-compose-button-by-composing-composable-functions-9f275772bd23)
 */
@Composable
fun YaaumButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    colors: YaaumButtonColors = YaaumButtonDefaults.colors,
    sizes: YaaumButtonSizes = YaaumButtonDefaults.sizes,
    shape: Shape = YaaumButtonDefaults.shape,
    textStyle: TextStyle = YaaumButtonDefaults.textStyle,
    animation: YaaumButtonAnimation = YaaumButtonDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    stateButton(
        text,
        onClick,
        icon,
        colors,
        sizes,
        shape,
        textStyle,
        animation,
        modifier,
        enabled,
        interactionSource,
    )
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumButton_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumButton(
            text = LoremIpsum(1).values.first(),
            onClick = { },
            icon = Icons.Default.Home,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumButton_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumButton(
            text = LoremIpsum(1).values.first(),
            onClick = { },
            icon = Icons.Default.Home,
        )
    }
}
