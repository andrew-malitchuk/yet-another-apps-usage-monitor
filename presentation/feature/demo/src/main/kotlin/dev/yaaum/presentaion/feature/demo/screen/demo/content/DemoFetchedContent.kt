package dev.yaaum.presentaion.feature.demo.screen.demo.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentaion.feature.demo.screen.demo.content.item.ColorListItem
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.composable.header.TitleHeader
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun DemoFetchedContent(
    onBackClick: (() -> Unit)? = null,
) {
    val scrollState = rememberScrollState()

    val faker = Faker()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background)
            .padding(top = YaaumTheme.spacing.small),
    ) {
        TitleHeader(
            onBackClick = onBackClick,
            title = Faker().quote.fortuneCookie(),
            modifier = Modifier
                .padding(
                    start = YaaumTheme.spacing.small,
                    end = YaaumTheme.spacing.small,
                    top = YaaumTheme.spacing.medium,
                    bottom = YaaumTheme.spacing.small,
                ),
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false)
                .background(YaaumTheme.colors.background)
                .padding(horizontal = YaaumTheme.spacing.medium),
            verticalArrangement = Arrangement
                .spacedBy(YaaumTheme.spacing.small),
        ) {
            Text(
                // TODO: fix
                text = "Colors",
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = YaaumTheme.spacing.small),
            )

            ColorListItem(
                color = YaaumTheme.colors.primary,
                name = "primary",
            )
            ColorListItem(
                color = YaaumTheme.colors.onPrimary,
                name = "onPrimary",
            )
            ColorListItem(
                color = YaaumTheme.colors.secondary,
                name = "secondary",
            )
            ColorListItem(
                color = YaaumTheme.colors.onSecondary,
                name = "onSecondary",
            )
            ColorListItem(
                color = YaaumTheme.colors.background,
                name = "background",
            )
            ColorListItem(
                color = YaaumTheme.colors.onBackground,
                name = "onBackground",
            )
            ColorListItem(
                color = YaaumTheme.colors.surface,
                name = "surface",
            )
            ColorListItem(
                color = YaaumTheme.colors.onSurface,
                name = "onSurface",
            )

            Text(
                // TODO: fix
                text = "Buttons",
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = YaaumTheme.spacing.small),
            )
            YaaumOrdinaryButton(
                title = faker.quote.fortuneCookie(),
                modifier = Modifier
                    .fillMaxWidth(),
                defaultBackgroundColor = YaaumTheme.colors.primary,
                pressedBackgroundColor = YaaumTheme.colors.secondary,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DemoFetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        DemoFetchedContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DemoFetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        DemoFetchedContent()
    }
}
