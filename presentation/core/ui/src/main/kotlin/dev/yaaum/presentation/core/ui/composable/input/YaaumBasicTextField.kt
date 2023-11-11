package dev.yaaum.presentation.core.ui.composable.input

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.composable.ext.clearFocusOnKeyboardDismiss
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun YaaumBasicTextField(
    modifier: Modifier = Modifier,
    text: String? = null,
    onTextChanged: ((String) -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
) {
    var textState by remember { mutableStateOf(text) }
    var isOnFocus by remember { mutableStateOf(true) }
    val bgColor: Color by animateColorAsState(
        if (isOnFocus) {
            YaaumTheme.colors.primary
        } else {
            YaaumTheme.colors.surface
        },
        label = "",
    )
    val focusRequester = remember { FocusRequester() }

    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged { state ->
                isOnFocus = state.isFocused
            }
            .clearFocusOnKeyboardDismiss(),
        value = textState ?: "",
        onValueChange = {
            onTextChanged?.invoke(it)
            textState = it
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        textStyle = YaaumTheme.typography.button,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        decorationBox = { innerTextField ->
            @Suppress("MagicNumber")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = YaaumTheme.colors.background,
                        shape = RoundedCornerShape(YaaumTheme.corners.medium),
                    )
                    .border(
                        width = YaaumTheme.dividers.extraSmall,
                        color = bgColor,
                        shape = RoundedCornerShape(YaaumTheme.corners.medium),
                    )
                    .padding(all = YaaumTheme.spacing.medium), // inner padding
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_magnifying_glass_bold_24),
                    contentDescription = null,
                    tint = YaaumTheme.colors.primary,
                )
                Spacer(modifier = Modifier.width(width = YaaumTheme.spacing.small))
                Box(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    innerTextField()
                }
                YaaumCircleButton(
                    icon = R.drawable.icon_caret_right_bold_24,
                    modifier = Modifier
                        // TODO: fix
                        .size(32.dp)
                        .align(Alignment.CenterVertically)
                        .alpha(
                            if (textState.isNullOrEmpty()) {
                                0f
                            } else {
                                1f
                            },
                        ),
                    defaultBackgroundColor = YaaumTheme.colors.primary,
                    pressedBackgroundColor = YaaumTheme.colors.secondary,
                    // TODO: fix
                    iconSize = 24.dp,
                    onClick = {
                    },
                )
            }
        },
    )
}
