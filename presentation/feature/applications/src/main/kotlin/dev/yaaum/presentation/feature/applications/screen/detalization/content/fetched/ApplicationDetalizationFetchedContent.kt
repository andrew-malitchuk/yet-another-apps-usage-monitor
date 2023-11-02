package dev.yaaum.presentation.feature.applications.screen.detalization.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.composable.card.ApplicationDetalizationCard
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun ApplicationDetalizationFetchedContent() {
    val lazyScrollState = rememberLazyListState()

    val foo = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background),
    ) {
        ApplicationDetalizationCard(
            modifier = Modifier
                .padding(
                    start = YaaumTheme.spacing.medium,
                    end = YaaumTheme.spacing.medium,
                    top = YaaumTheme.spacing.small,
                    bottom = YaaumTheme.spacing.small,
                ),
//            isFoo = (!lazyScrollState.canScrollBackward && !lazyScrollState.isScrollInProgress),
            isFoo = foo.value,
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
                .background(YaaumTheme.colors.background)
                .padding(horizontal = YaaumTheme.spacing.medium),
            state = lazyScrollState,
            verticalArrangement = Arrangement
                .spacedBy(YaaumTheme.spacing.small),
        ) {
            item {
                Button(
                    onClick = {
                        foo.value = foo.value.not()
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(text = "foobar")
                }
            }
        }
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
