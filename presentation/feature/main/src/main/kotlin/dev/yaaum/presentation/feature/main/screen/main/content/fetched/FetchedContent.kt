package dev.yaaum.presentation.feature.main.screen.main.content.fetched

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.card.GeneralHealthCard
import dev.yaaum.presentation.core.ui.composable.header.SimpleHeader
import dev.yaaum.presentation.core.ui.composable.indicator.YaaumPageIndicator
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.block.LimitedApplicationListBlock
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.block.RecommendationBlock
import io.github.serpro69.kfaker.Faker

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FetchedContent(
    onSettingsClick: (() -> Unit)? = null,
    onHealthClick: (() -> Unit)? = null,
    onMoreClick: (() -> Unit)? = null,
    topAppsWithHighestUsage: State<List<TimeUsageUiModel>?>,
) {
    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState(
        pageCount = {
            10
        },
    )

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
        GeneralHealthCard(
            onClick = onHealthClick,
        )
        LimitedApplicationListBlock(
            title = Faker().quote.fortuneCookie(),
            list = topAppsWithHighestUsage,
            onMoreClick = onMoreClick,
        )
        RecommendationBlock(
            title = Faker().quote.fortuneCookie(),
            list = listOf("foo", "bar", "foobar"),
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
        ) { page ->
            Box(modifier = Modifier.fillMaxSize()) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Box(
                        modifier = Modifier.size(128.dp),
                    ) {
                    }
                }
            }
        }
        YaaumPageIndicator(
            pagerState = pagerState,
        )
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
