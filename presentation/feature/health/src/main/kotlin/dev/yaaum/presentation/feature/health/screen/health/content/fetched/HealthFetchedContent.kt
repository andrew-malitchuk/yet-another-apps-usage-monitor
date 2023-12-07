package dev.yaaum.presentation.feature.health.screen.health.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.ui.composable.card.ProgressHealthCard
import dev.yaaum.presentation.core.ui.composable.various.AnimatedDivider
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.health.screen.health.mvi.HealthMviState

@Composable
@Suppress("UnusedParameter")
fun HealthFetchedContent(
    state: HealthMviState,
    onActionClick: (() -> Unit)? = null,
    onApplicationClick: ((ApplicationsUiModel) -> Unit)? = null,
) {
    val scrollState = rememberScrollState()
    val lazyScrollState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background),
    ) {
        ProgressHealthCard(
            modifier = Modifier
                .padding(
                    top = YaaumTheme.spacing.medium,
                    start = YaaumTheme.spacing.medium,
                    end = YaaumTheme.spacing.medium,
                    bottom = YaaumTheme.spacing.small,
                ),
            isOpened = (!lazyScrollState.canScrollBackward && !lazyScrollState.isScrollInProgress),
            onClick = onActionClick,
        )
        AnimatedDivider(
            state = lazyScrollState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
        /* LazyColumn(
             modifier = Modifier
                 .fillMaxWidth()
                 .weight(1.0f)
                 .background(YaaumTheme.colors.background)
                 .padding(horizontal = YaaumTheme.spacing.medium),
             state = lazyScrollState,
             verticalArrangement = Arrangement
                 .spacedBy(YaaumTheme.spacing.small),
         ) {
             applicationList.value?.let {
                 items(
                     count = it.size,
                 ) { index ->
                     ApplicationListItem(
                         applicationsUiModel = it[index],
                         onApplicationClick = onApplicationClick,
                     )
                 }
             }
         }*/
        AnimatedDivider(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            state = lazyScrollState,
            isInverted = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_HealthFetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        HealthFetchedContent(
            // TODO: fix me
            state = HealthMviState.loading(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_HealthFetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        HealthFetchedContent(
            // TODO: fix me
            state = HealthMviState.loading(),
        )
    }
}
