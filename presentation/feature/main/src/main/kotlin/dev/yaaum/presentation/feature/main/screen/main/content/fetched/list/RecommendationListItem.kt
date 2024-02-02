package dev.yaaum.presentation.feature.main.screen.main.content.fetched.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.models.RecommendationUiModel
import dev.yaaum.presentation.core.ui.composable.item.YaaumBaseListContainer
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker
import kotlin.math.abs

@Suppress("MagicNumber")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendationListItem(
    modifier: Modifier = Modifier,
    recommendationUiModel: RecommendationUiModel?,
    onRecommendationClick: ((RecommendationUiModel) -> Unit)? = null,
    state: PagerState,
) {
    val position = state.currentPageOffsetFraction
    val scaleMultiplier = 0.25
    val minScale = 0.75
    val scaleValue = if (position < 0) {
        (((minScale - (-position) * scaleMultiplier).toFloat() + scaleMultiplier).toFloat())
    } else if (position > 0 && position <= 1) {
        (((minScale - position * scaleMultiplier).toFloat() + scaleMultiplier).toFloat())
    } else {
        1f
    }
    val alphaValue = if (position < 0) {
        (1 - abs(position))
    } else if (position > 0 && position <= 1) {
        (1 - position)
    } else {
        1f
    }
    YaaumBaseListContainer(
        modifier = modifier
            .wrapContentHeight()
            .padding(horizontal = YaaumTheme.spacing.medium)
            .scale(scaleValue)
            .alpha(alphaValue)
            .fillMaxWidth(),
        onClick = {
            recommendationUiModel?.let { onRecommendationClick?.invoke(it) }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(YaaumTheme.spacing.small),
        ) {
            Text(
                text = recommendationUiModel?.description ?: "",
                style = YaaumTheme.typography.caption,
                color = YaaumTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.largest))
            Text(
                text = recommendationUiModel?.title ?: "",
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun Preview_RecommendationListItem_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        RecommendationListItem(
            recommendationUiModel = RecommendationUiModel(
                title = faker.quote.fortuneCookie(),
                description = faker.quote.fortuneCookie(),
                deeplink = "",
            ),
            state = rememberPagerState {
                1
            },
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun Preview_RecommendationListItem_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        RecommendationListItem(
            recommendationUiModel = RecommendationUiModel(
                title = faker.quote.fortuneCookie(),
                description = faker.quote.fortuneCookie(),
                deeplink = "",
            ),
            state = rememberPagerState {
                1
            },
        )
    }
}
