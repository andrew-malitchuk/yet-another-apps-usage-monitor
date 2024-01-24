package dev.yaaum.presentation.feature.settings.dialog.language.item

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun LanguageListItem(
    modifier: Modifier = Modifier,
    lang: String,
    onApplicationClick: ((String, Boolean) -> Unit)? = null,
) {
//    val isChosen = remember { mutableStateOf(applicationsUiModel.isChosen) }
    val isChosen = remember { mutableStateOf(true) }

    val animatedDpValue by animateDpAsState(
        targetValue = if (isChosen.value) {
            YaaumTheme.dividers.extraSmall
        } else {
            0.dp
        },
        label = "animatedDpValue",
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .border(
                width = animatedDpValue,
                color = if (animatedDpValue != 0.dp) {
                    YaaumTheme.colors.primary
                } else {
                    Color.Transparent
                },
                shape = RoundedCornerShape(YaaumTheme.corners.medium),
            )
            .background(YaaumTheme.colors.surface)
            .padding(YaaumTheme.spacing.small)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    isChosen.value = isChosen.value.not()
                    onApplicationClick?.invoke(lang, isChosen.value)
                },
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // TODO: add sizes
        Box(
            modifier = Modifier
                .size(YaaumTheme.icons.medium)
                .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                .align(Alignment.CenterVertically)
                .background(YaaumTheme.colors.secondary),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = lang,
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
        Text(
            // TODO: fix
            text = "LANG",
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListItem_Dark() {
    YaaumTheme(useDarkTheme = true) {
        LanguageListItem(
            lang = "ukr",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListItem_Light() {
    YaaumTheme(useDarkTheme = false) {
        LanguageListItem(
            lang = "ukr",
        )
    }
}
