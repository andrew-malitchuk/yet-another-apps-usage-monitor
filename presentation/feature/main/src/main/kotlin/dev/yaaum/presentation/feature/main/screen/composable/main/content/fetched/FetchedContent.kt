package dev.yaaum.presentation.feature.main.screen.composable.main.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.card.GeneralHealthCard
import dev.yaaum.presentation.core.ui.composable.header.SimpleHeader
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.composable.main.content.fetched.block.LimitedApplicationListBlock
import dev.yaaum.presentation.feature.main.screen.composable.main.content.fetched.block.RecommendationBlock
import io.github.serpro69.kfaker.Faker

@Composable
fun FetchedContent(
    onSettingsClick: (() -> Unit)? = null,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background)
            .padding(YaaumTheme.spacing.medium),
        verticalArrangement = Arrangement.spacedBy(YaaumTheme.spacing.small),
    ) {
        SimpleHeader(
            icon = ImageVector.vectorResource(R.drawable.icon_gear_six_bold_24),
            onClick = onSettingsClick,
        )
        GeneralHealthCard()
        LimitedApplicationListBlock(
            title = Faker().quote.fortuneCookie(),
            list = listOf("foo", "bar", "foobar"),
        )
        RecommendationBlock(
            title = Faker().quote.fortuneCookie(),
            list = listOf("foo", "bar", "foobar"),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_FetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        FetchedContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_FetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        FetchedContent()
    }
}
