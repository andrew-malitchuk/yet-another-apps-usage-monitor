package dev.yaaum.presentation.feature.health.screen.health.content.fetched

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.card.ProgressHealthCard
import dev.yaaum.presentation.core.ui.composable.header.SimpleHeader
import dev.yaaum.presentation.core.ui.composable.various.AnimatedDivider
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.health.screen.health.content.fetched.list.ApplicationListItem

@Composable
fun HealthFetchedContent(
    applicationList: State<List<ApplicationsUiModel>?>,
) {
    val scrollState = rememberScrollState()

    val foo = remember { mutableStateOf(true) }
    val lazyScrollState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background),
    ) {
        SimpleHeader(
            modifier = Modifier
                .padding(
                    start = YaaumTheme.spacing.medium,
                    end = YaaumTheme.spacing.medium,
                    top = YaaumTheme.spacing.medium,
                ),
            icon = ImageVector.vectorResource(R.drawable.icon_gear_six_bold_24),
            onClick = {
                foo.value = foo.value.not()
            },
        )
        ProgressHealthCard(
            modifier = Modifier
                .padding(
                    start = YaaumTheme.spacing.medium,
                    end = YaaumTheme.spacing.medium,
                    top = YaaumTheme.spacing.small,
                    bottom = YaaumTheme.spacing.small,
                ),
            isFoo = (!lazyScrollState.canScrollBackward && !lazyScrollState.isScrollInProgress),
        )
        AnimatedDivider(
            state = lazyScrollState,
            modifier = Modifier
                .fillMaxWidth(),
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
            applicationList.value?.let {
                items(
                    count = it.size,
                ) { index ->
                    ApplicationListItem(
                        applicationsUiModel = it[index],
                    )
                }
            }
        }
        AnimatedDivider(state = lazyScrollState, isInverted = true)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_HealthFetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        HealthFetchedContent(
            applicationList = remember { mutableStateOf(emptyList()) },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_HealthFetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        HealthFetchedContent(
            applicationList = remember { mutableStateOf(emptyList()) },
        )
    }
}
