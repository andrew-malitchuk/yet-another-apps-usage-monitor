package dev.yaaum.presentation.feature.main.screen.composable.applications.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.composable.applications.content.item.ApplicationListItem

@Composable
fun ApplicationsContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(YaaumTheme.colors.background),
    ) {
        @Suppress("MagicNumber")
        val lazyPagingItems = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(YaaumTheme.spacing.small),
            verticalArrangement = Arrangement.spacedBy(YaaumTheme.spacing.small),
        ) {
            items(
                count = lazyPagingItems.size,
            ) { index ->
                ApplicationListItem()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationsContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationsContent()
    }
}
