package dev.yaaum.presentation.feature.main.screen.main.item.fetched

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.ui.composable.item.YaaumBaseListContainer
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun ApplicationFetchedListItem(
    modifier: Modifier = Modifier,
    timeUsageUiModel: TimeUsageUiModel,
    onApplicationClick: ((TimeUsageUiModel) -> Unit)? = null,
) {
    YaaumBaseListContainer(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = {
            onApplicationClick?.invoke(timeUsageUiModel)
        },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(YaaumTheme.spacing.small),
        ) {
            Box(
                modifier = Modifier
                    .size(YaaumTheme.icons.medium)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                    .align(Alignment.CenterVertically)
                    .background(YaaumTheme.colors.secondary),
            ) {
                val icon = timeUsageUiModel.packageName?.let { pn ->
                    LocalContext.current.packageManager.getApplicationIcon(pn)
                }
                Image(
                    painter = rememberDrawablePainter(icon),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .padding(YaaumTheme.spacing.small),
                )
            }
            Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
            Column(
                modifier = Modifier,
            ) {
                Text(
                    text = timeUsageUiModel.applicationName ?: timeUsageUiModel.packageName
                        ?: "SWW",
                    style = YaaumTheme.typography.title,
                    color = YaaumTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(YaaumTheme.spacing.extraSmall))
                Text(
                    text = timeUsageUiModel.totalTimeInForegroundHumanReadable,
                    style = YaaumTheme.typography.caption,
                    color = YaaumTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationFetchedListItem_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        ApplicationFetchedListItem(
            timeUsageUiModel = TimeUsageUiModel(
                applicationName = faker.quote.fortuneCookie(),
                packageName = faker.quote.fortuneCookie(),
                usageBegin = 0L,
                usageEnd = System.currentTimeMillis(),
                totalTimeInForeground = 0L,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationFetchedListItem_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        ApplicationFetchedListItem(
            timeUsageUiModel = TimeUsageUiModel(
                applicationName = faker.quote.fortuneCookie(),
                packageName = faker.quote.fortuneCookie(),
                usageBegin = 0L,
                usageEnd = System.currentTimeMillis(),
                totalTimeInForeground = 0L,
            ),
        )
    }
}
