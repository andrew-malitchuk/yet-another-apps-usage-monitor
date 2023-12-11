package dev.yaaum.presentation.feature.applications.screen.applications.content.empty

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun ApplicationsEmptyContent(
    modifier: Modifier = Modifier,
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
            Text(
                text = UiText
                    .StringResource(dev.yaaum.presentation.core.localisation.R.string.applications_empty_title)
                    .asString(LocalContext.current),
                style = YaaumTheme.typography.display,
                color = YaaumTheme.colors.onBackground,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
            Text(
                text = UiText
                    .StringResource(dev.yaaum.presentation.core.localisation.R.string.applications_empty_description)
                    .asString(LocalContext.current),
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onBackground,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
            Image(
                painter = painterResource(id = dev.yaaum.presentation.core.ui.R.drawable.ic_placeholder_bold_24),
                contentDescription = null,
                modifier = Modifier
                    .size(YaaumTheme.icons.large),
                colorFilter = ColorFilter.tint(YaaumTheme.colors.primary),
                contentScale = ContentScale.Fit,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsEmptyContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationsEmptyContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsEmptyContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationsEmptyContent()
    }
}
