package dev.yaaum.presentation.feature.settings.screen.about.content.fetched

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.feature.settings.R
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun AboutFetchedContent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background)
            .padding(YaaumTheme.spacing.medium),
    ) {
        Image(
            painter = painterResource(id = dev.yaaum.presentation.core.ui.R.drawable.illustration_yaaum_649_250),
            contentDescription = null,
            colorFilter = ColorFilter.tint(YaaumTheme.colors.onBackground),
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
        Text(
            text = Faker().quote.fortuneCookie(),
            style = YaaumTheme.typography.display,
            color = YaaumTheme.colors.primary,
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
        Text(
            text = Faker().quote.fortuneCookie(),
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.extraLarge))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement
                .spacedBy(YaaumTheme.spacing.small),
        ) {
            // TODO: add sizes
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                    .align(Alignment.CenterVertically)
                    .background(YaaumTheme.colors.secondary)
                    .clickable {
                    },
            ) {
                Image(
                    painter = painterResource(id = dev.yaaum.presentation.core.ui.R.drawable.icon_github_logo_bold_24),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .padding(YaaumTheme.spacing.small),
                )
            }
            // TODO: add sizes
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                    .align(Alignment.CenterVertically)
                    .background(YaaumTheme.colors.secondary)
                    .clickable {
                    },
            ) {
                Image(
                    painter = painterResource(id = dev.yaaum.presentation.core.ui.R.drawable.icon_bug_droid_bold_24),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .padding(YaaumTheme.spacing.small),
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "some-version-code",
            style = YaaumTheme.typography.caption,
            color = YaaumTheme.colors.onBackground,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_AboutFetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        AboutFetchedContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_AboutFetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        AboutFetchedContent()
    }
}
