package dev.yaaum.presentation.core.ui.composable.content.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.R
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.error.NoDataUiError
import dev.yaaum.presentation.core.ui.error.base.BaseUiError
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun DefaultErrorContent(
    modifier: Modifier = Modifier,
    error: BaseUiError,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(YaaumTheme.colors.background),
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(YaaumTheme.spacing.medium),
        ) {
            // TODO: fix
            Text(
                text = UiText.StringResource(R.string.error_sww).asString(LocalContext.current),
                style = YaaumTheme.typography.display,
                color = YaaumTheme.colors.onBackground,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
            // TODO: fix
            Text(
                text =
                error.message?.asString(LocalContext.current)
                    ?: UiText.StringResource(R.string.error_unknown).asString(LocalContext.current),
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onBackground,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
            YaaumOrdinaryButton(
                title = UiText.StringResource(R.string.various_ok).asString(LocalContext.current),
                modifier = Modifier
                    .fillMaxWidth(),
                defaultBackgroundColor = YaaumTheme.colors.primary,
                pressedBackgroundColor = YaaumTheme.colors.secondary,
                onClick = {
                    onClick?.invoke()
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DefaultErrorContent_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        DefaultErrorContent(
            error = NoDataUiError(
                message = UiText.DynamicString(faker.quote.fortuneCookie()),
                throwable = null,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DefaultErrorContent_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        DefaultErrorContent(
            error = NoDataUiError(
                message = UiText.DynamicString(faker.quote.fortuneCookie()),
                throwable = null,
            ),
        )
    }
}
