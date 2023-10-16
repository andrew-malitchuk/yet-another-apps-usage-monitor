package dev.yaaum.presentation.feature.main.screen.main.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumDefaultOrdinaryButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun ErrorContent(
    title: String,
    description: String,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(YaaumTheme.colors.background),
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
                .padding(YaaumTheme.spacing.medium),
        ) {
            Text(
                text = title,
                style = YaaumTheme.typography.display,
                color = YaaumTheme.colors.onBackground,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
            Text(
                text = description,
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onBackground,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.extraMedium))
            YaaumDefaultOrdinaryButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Next",
                onClick = { onClick?.invoke() },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ErrorContent_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        ErrorContent(
            title = faker.quote.fortuneCookie(),
            description = faker.quote.fortuneCookie(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ErrorContent_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        ErrorContent(
            title = faker.quote.fortuneCookie(),
            description = faker.quote.fortuneCookie(),
        )
    }
}
