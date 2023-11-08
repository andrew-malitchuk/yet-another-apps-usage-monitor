package dev.yaaum.presentation.feature.main.screen.main.content.fetched

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.models.RecommendationUiModel
import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.card.GeneralHealthCard
import dev.yaaum.presentation.core.ui.composable.header.SimpleHeader
import dev.yaaum.presentation.core.ui.composable.various.pulltorefresh.YaaumPullToRefreshLayout
import dev.yaaum.presentation.core.ui.composable.various.pulltorefresh.YaaumPullToRefreshLayoutState
import dev.yaaum.presentation.core.ui.composable.various.pulltorefresh.YaaumRefreshIndicatorState
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.block.LimitedApplicationListBlock
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.block.RecommendationBlock
import io.github.serpro69.kfaker.Faker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun FetchedContent(
    onSettingsClick: (() -> Unit)? = null,
    onHealthClick: (() -> Unit)? = null,
    onMoreClick: (() -> Unit)? = null,
    topAppsWithHighestUsage: State<List<TimeUsageUiModel>?>,
) {
    val scrollState = rememberScrollState()

    val pullToRefreshState = YaaumPullToRefreshLayoutState(
        onTimeUpdated = { timeElapsed ->
            timeElapsed.toString()
        },
    )

    YaaumPullToRefreshLayout(
        modifier = Modifier.fillMaxSize(),
        pullRefreshLayoutState = pullToRefreshState,
        onRefresh = {
            // Duct tape
            GlobalScope.launch(Dispatchers.Main) {
                pullToRefreshState.updateRefreshState(YaaumRefreshIndicatorState.Default)
                pullToRefreshState.updateRefreshState(YaaumRefreshIndicatorState.Refreshing)
                @Suppress("MagicNumber")
                delay(2_000L)
                pullToRefreshState.updateRefreshState(YaaumRefreshIndicatorState.Default)
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(YaaumTheme.colors.background)
                .padding(vertical = YaaumTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(YaaumTheme.spacing.small),
        ) {
            SimpleHeader(
                modifier = Modifier
                    .padding(horizontal = YaaumTheme.spacing.medium),
                icon = ImageVector.vectorResource(R.drawable.icon_gear_six_bold_24),
                onClick = onSettingsClick,
            )
            GeneralHealthCard(
                modifier = Modifier
                    .padding(horizontal = YaaumTheme.spacing.medium),
                onClick = onHealthClick,
            )
            LimitedApplicationListBlock(
                modifier = Modifier
                    .padding(horizontal = YaaumTheme.spacing.medium),
                title = Faker().quote.fortuneCookie(),
                list = topAppsWithHighestUsage,
                onMoreClick = onMoreClick,
            )
            RecommendationBlock(
                title = Faker().quote.fortuneCookie(),
                list = listOf(
                    RecommendationUiModel(
                        title = Faker().quote.fortuneCookie(),
                        description = Faker().quote.fortuneCookie(),
                        deeplink = "",
                    ),
                    RecommendationUiModel(
                        title = Faker().quote.fortuneCookie(),
                        description = Faker().quote.fortuneCookie(),
                        deeplink = "",
                    ),
                    RecommendationUiModel(
                        title = Faker().quote.fortuneCookie(),
                        description = Faker().quote.fortuneCookie(),
                        deeplink = "",
                    ),
                    RecommendationUiModel(
                        title = Faker().quote.fortuneCookie(),
                        description = Faker().quote.fortuneCookie(),
                        deeplink = "",
                    ),
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_FetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        FetchedContent(
            topAppsWithHighestUsage = remember { mutableStateOf(emptyList()) },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_FetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        FetchedContent(
            topAppsWithHighestUsage = remember { mutableStateOf(emptyList()) },
        )
    }
}
