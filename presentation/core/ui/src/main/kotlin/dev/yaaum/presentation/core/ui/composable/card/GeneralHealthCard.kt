package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.common.core.ext.asHours
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.GeneralTimeUsageStatisticUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.ext.placeholder
import dev.yaaum.presentation.core.ui.composable.item.YaaumBaseListContainer
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * General information about "user's health"
 */
@Suppress("LongMethod")
@Composable
fun GeneralHealthCard(
    timeUsage: GeneralTimeUsageStatisticUiModel?,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    var composableWidth by remember { mutableIntStateOf(0) }
    YaaumBaseListContainer(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = {
            onClick?.invoke()
        },
    ) {
        when {
            (timeUsage == null) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .placeholder(
                            backgroundColor = YaaumTheme.colors.surface,
                            isLoading = true,
                            shape = RoundedCornerShape(YaaumTheme.corners.medium),
                        )
                        .padding(YaaumTheme.spacing.medium),
                ) {
                    @Suppress("MagicNumber")
                    Box(modifier = Modifier.height(128.dp))
                }

            else ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(YaaumTheme.spacing.small)
                        .onSizeChanged {
                            composableWidth = it.width
                        },
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(YaaumTheme.icons.medium)
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                                .background(YaaumTheme.colors.secondary),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_chart_pie_slice_bold_24),
                                colorFilter = ColorFilter.tint(YaaumTheme.colors.onPrimary),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .align(Alignment.Center)
                                    .padding(YaaumTheme.spacing.small),
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .width(YaaumTheme.spacing.small),
                        )
                        Text(
                            text = UiText
                                .StringResource(dev.yaaum.presentation.core.localisation.R.string.health_month)
                                .asString(LocalContext.current),
                            style = YaaumTheme.typography.title,
                            color = YaaumTheme.colors.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier,
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .height(YaaumTheme.spacing.medium),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                    ) {
                        Column(
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight(),
                        ) {
                            Row(
                                modifier = Modifier
                                    .wrapContentHeight(),
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_bookmarks_bold_24),
                                    contentDescription = null,
                                    tint = YaaumTheme.colors.onPrimary,
                                    modifier = Modifier
                                        .size(YaaumTheme.icons.small)
                                        .clip(CircleShape)
                                        .background(YaaumTheme.colors.primary)
                                        .padding(YaaumTheme.spacing.extraSmall),
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(YaaumTheme.spacing.small),
                                )
                                Text(
                                    text = timeUsage.totalAppsUsage.asHours(),
                                    style = YaaumTheme.typography.title,
                                    color = YaaumTheme.colors.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                            Spacer(
                                modifier = Modifier
                                    .height(YaaumTheme.spacing.small),
                            )
                            Row(
                                modifier = Modifier
                                    .wrapContentHeight(),
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_bookmarks_bold_24),
                                    contentDescription = null,
                                    tint = YaaumTheme.colors.onSecondary,
                                    modifier = Modifier
                                        .size(YaaumTheme.icons.small)
                                        .clip(CircleShape)
                                        .background(YaaumTheme.colors.secondary)
                                        .padding(YaaumTheme.spacing.extraSmall),
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(YaaumTheme.spacing.small),
                                )
                                Text(
                                    text = timeUsage.totalUsersAppsUsage.asHours(),
                                    style = YaaumTheme.typography.title,
                                    color = YaaumTheme.colors.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                            Spacer(
                                modifier = Modifier
                                    .height(YaaumTheme.spacing.small),
                            )
                            Row(
                                modifier = Modifier
                                    .wrapContentHeight(),
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_bookmarks_bold_24),
                                    contentDescription = null,
                                    tint = YaaumTheme.colors.surface,
                                    modifier = Modifier
                                        .size(YaaumTheme.icons.small)
                                        .clip(CircleShape)
                                        .background(YaaumTheme.colors.onSurface)
                                        .padding(YaaumTheme.spacing.extraSmall),
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(YaaumTheme.spacing.small),
                                )
                                Text(
                                    text = timeUsage.totalChosenAppsUsage.asHours(),
                                    style = YaaumTheme.typography.title,
                                    color = YaaumTheme.colors.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Column(
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight(),
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                text = "Streak",
                                style = YaaumTheme.typography.subHeading,
                                color = YaaumTheme.colors.onSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier,
                            )
                            Spacer(modifier = Modifier.height(YaaumTheme.spacing.small))
                            Row(
                                modifier = Modifier
                                    .wrapContentSize(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = "90",
                                    style = YaaumTheme.typography.display,
                                    color = YaaumTheme.colors.primary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier,
                                )
                                Spacer(modifier = Modifier.height(YaaumTheme.spacing.small))
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_fire_bold_24),
                                    contentDescription = null,
                                    tint = YaaumTheme.colors.primary,
                                    modifier = Modifier
                                        .size(YaaumTheme.icons.medium),
                                )
                            }
                        }
                    }
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_GeneralHealthCard_Loading_Dark() {
    YaaumTheme(useDarkTheme = true) {
        GeneralHealthCard(timeUsage = null)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_GeneralHealthCard_Loading_Light() {
    YaaumTheme(useDarkTheme = false) {
        GeneralHealthCard(timeUsage = null)
    }
}

@Preview(showBackground = true)
@Composable
@Suppress("MagicNumber")
fun Preview_GeneralHealthCard_Fetched_Dark() {
    YaaumTheme(useDarkTheme = true) {
        GeneralHealthCard(timeUsage = GeneralTimeUsageStatisticUiModel(100, 100, 100))
    }
}

@Preview(showBackground = true)
@Composable
@Suppress("MagicNumber")
fun Preview_GeneralHealthCard_Fetched_Light() {
    YaaumTheme(useDarkTheme = false) {
        GeneralHealthCard(timeUsage = GeneralTimeUsageStatisticUiModel(100, 100, 100))
    }
}
