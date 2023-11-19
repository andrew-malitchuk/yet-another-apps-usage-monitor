package dev.yaaum.presentation.core.ui.composable.button.circle

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

/**
 * Circle button with optional [title] or/and [icon]
 *
 * @param modifier
 * @param title text to display on button
 * @param icon icon to display on button
 * @param onClick lambda
 * @param iconSize size of the [icon]
 * @param iconPadding padding between [icon] and borders
 * @param defaultBackgroundColor
 * @param pressedBackgroundColor
 * @param defaultForegroundColor
 * @param pressedForegroundColor
 * @param textStyle style of the [title]
 * @param textSpacing padding [icon] and borders
 * @param contentSpacing padding between borders and content
 */
@Composable
fun YaaumCircleButton(
    modifier: Modifier = Modifier,
    title: String? = null,
    @DrawableRes
    icon: Int? = null,
    onClick: (() -> Unit)? = null,
    // TODO: fix
    iconSize: Dp = 32.dp,
    iconPadding: Dp = 0.dp,
    defaultBackgroundColor: Color = YaaumTheme.colors.secondary,
    pressedBackgroundColor: Color = YaaumTheme.colors.primary,
    defaultForegroundColor: Color = YaaumTheme.colors.onSecondary,
    pressedForegroundColor: Color = YaaumTheme.colors.onPrimary,
    textStyle: TextStyle = YaaumTheme.typography.title,
    textSpacing: Dp = YaaumTheme.spacing.small,
    contentSpacing: Dp = YaaumTheme.spacing.small,
) {
    var isPressed by remember {
        mutableStateOf(false)
    }

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

    Row(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .clip(CircleShape)
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
                            onClick?.invoke()
                        }
                    },
                )
            }
            .padding(contentSpacing),
    ) {
        icon?.let {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(iconSize)
                    .align(Alignment.CenterVertically)
                    .padding(iconPadding),
                colorFilter = ColorFilter.tint(foregroundColor),
            )
        }
        title?.let {
            Spacer(
                modifier = Modifier
                    .width(textSpacing),
            )
            Text(
                text = it,
                style = textStyle,
                color = foregroundColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_BarButton_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        YaaumCircleButton(
            icon = R.drawable.icon_fire_bold_24,
            title = faker.quote.fortuneCookie(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_BarButton_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        YaaumCircleButton(
            icon = R.drawable.icon_fire_bold_24,
            title = faker.quote.fortuneCookie(),
        )
    }
}
