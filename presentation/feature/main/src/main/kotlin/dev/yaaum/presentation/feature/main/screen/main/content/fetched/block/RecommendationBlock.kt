package dev.yaaum.presentation.feature.main.screen.main.content.fetched.block

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.models.RecommendationUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.composable.ext.placeholder
import dev.yaaum.presentation.core.ui.composable.indicator.YaaumPageIndicator
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.list.RecommendationListItem
import io.github.serpro69.kfaker.Faker

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendationBlock(
    modifier: Modifier = Modifier,
    title: String,
    list: List<RecommendationUiModel>?,
    onInfoClick: (() -> Unit)? = null,
) {
    val pagerState = rememberPagerState(
        pageCount = {
            list?.size ?: 0
        },
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = YaaumTheme.spacing.medium),
        ) {
            Text(
                text = title,
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
            )
            Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
            YaaumCircleButton(
                icon = R.drawable.icon_info_bold_24,
                modifier = Modifier,
                defaultBackgroundColor = YaaumTheme.colors.primary,
                pressedBackgroundColor = YaaumTheme.colors.secondary,
                iconSize = YaaumTheme.icons.extraSmall,
                onClick = {
                    onInfoClick?.invoke()
                },
            )
        }
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.small))
        if (list == null) {
            RecommendationListItem(
                recommendationUiModel = null,
                state = pagerState,
                modifier = Modifier
                    .padding(
                        horizontal = YaaumTheme.spacing.medium,
                    )
                    .placeholder(
                        backgroundColor = YaaumTheme.colors.surface,
                        isLoading = true,
                        shape = RoundedCornerShape(YaaumTheme.corners.medium),
                    ),
            )
        } else {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(YaaumTheme.colors.background),
            ) { page ->
                RecommendationListItem(
                    recommendationUiModel = list[page],
                    state = pagerState,
                )
            }
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.small))
            YaaumPageIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = YaaumTheme.spacing.medium),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_RecommendationBlock_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        RecommendationBlock(
            title = faker.quote.fortuneCookie(),
            list = listOf(
                RecommendationUiModel(
                    title = faker.quote.fortuneCookie(),
                    description = faker.quote.fortuneCookie(),
                    deeplink = "",
                ),
                RecommendationUiModel(
                    title = faker.quote.fortuneCookie(),
                    description = faker.quote.fortuneCookie(),
                    deeplink = "",
                ),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_RecommendationBlock_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        RecommendationBlock(
            title = faker.quote.fortuneCookie(),
            list = listOf(
                RecommendationUiModel(
                    title = faker.quote.fortuneCookie(),
                    description = faker.quote.fortuneCookie(),
                    deeplink = "",
                ),
                RecommendationUiModel(
                    title = faker.quote.fortuneCookie(),
                    description = faker.quote.fortuneCookie(),
                    deeplink = "",
                ),
            ),
        )
    }
}
