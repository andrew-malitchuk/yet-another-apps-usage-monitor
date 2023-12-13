package dev.yaaum.presentation.feature.settings.screen.settings.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.ThemeUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.various.SelectedTheme
import dev.yaaum.presentation.core.ui.composable.button.various.YaaumThemeButton
import dev.yaaum.presentation.core.ui.composable.button.various.toSelectedTheme
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun ThemeListItem(
    theme: ThemeUiModel? = null,
    onThemeSelected: ((SelectedTheme) -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.surface)
            .padding(YaaumTheme.spacing.small),
    ) {
        Box(
            modifier = Modifier
                .size(YaaumTheme.icons.medium)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                .align(Alignment.CenterVertically)
                .background(YaaumTheme.colors.secondary),
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_paint_roller_bold_24),
                colorFilter = ColorFilter.tint(YaaumTheme.colors.onSurface),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(YaaumTheme.spacing.small),
            )
        }
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
        Text(
            text = UiText
                .StringResource(dev.yaaum.presentation.core.localisation.R.string.settings_theme)
                .asString(LocalContext.current),
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
        Spacer(modifier = Modifier.weight(1f))
        YaaumThemeButton(
            modifier = Modifier,
            preselectedTheme = theme?.toSelectedTheme(),
            onThemeSelected = onThemeSelected,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ThemeListItem_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ThemeListItem()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ThemeListItem_Light() {
    YaaumTheme(useDarkTheme = false) {
        ThemeListItem()
    }
}
