package dev.yaaum.presentation.core.ui.composable.header

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
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun TitleHeader(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background)
            .padding(horizontal = YaaumTheme.spacing.medium),
    ) {
        YaaumOrdinaryButton(
            icon = R.drawable.icon_caret_left_bold_24,
            modifier = Modifier
                .align(Alignment.CenterVertically),
            defaultBackgroundColor = YaaumTheme.colors.secondary,
            pressedBackgroundColor = YaaumTheme.colors.primary,
            // TODO: fix
            iconSize = 32.dp,
            onClick = {
                onBackClick?.invoke()
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
            title = faker.quote.fortuneCookie(),
        )
    }
}
