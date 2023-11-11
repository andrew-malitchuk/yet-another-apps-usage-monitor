package dev.yaaum.presentation.core.ui.composable.header

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun TitleHeader(
    modifier: Modifier = Modifier,
    @DrawableRes
    icon: Int,
    title: String,
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background)
            .padding(horizontal = YaaumTheme.spacing.medium),
    ) {
        YaaumCircleButton(
            icon = icon,
            modifier = Modifier,
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            // TODO: fix
            iconSize = 32.dp,
            onClick = {
                onClick?.invoke()
            },
        )
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
        Text(
            // TODO: fix
            text = title,
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.CenterVertically),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_TitleHeader_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        TitleHeader(
            icon = R.drawable.icon_gear_six_bold_24,
            title = faker.quote.fortuneCookie(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_TitleHeader_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        TitleHeader(
            icon = R.drawable.icon_gear_six_bold_24,
            title = faker.quote.fortuneCookie(),
        )
    }
}
