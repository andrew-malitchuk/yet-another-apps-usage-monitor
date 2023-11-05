package dev.yaaum.presentation.feature.applications.screen.detalization.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.composable.card.ApplicationDetalizationCard
import dev.yaaum.presentation.core.ui.composable.card.DetailsHealthCard
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun ApplicationDetalizationFetchedContent() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background)
            .padding(horizontal = YaaumTheme.spacing.medium),
        verticalArrangement = Arrangement
            .spacedBy(YaaumTheme.spacing.small),
    ) {
        ApplicationDetalizationCard(
            modifier = Modifier
                .padding(top = YaaumTheme.spacing.small),
        )
        DetailsHealthCard()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationFetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationDetalizationFetchedContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationFetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationDetalizationFetchedContent()
    }
}
