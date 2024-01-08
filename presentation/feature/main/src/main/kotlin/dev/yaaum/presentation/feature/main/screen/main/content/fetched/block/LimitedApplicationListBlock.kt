package dev.yaaum.presentation.feature.main.screen.main.content.fetched.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.TimeUsageUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.list.NoPermissionItem
import dev.yaaum.presentation.feature.main.screen.main.item.fetched.ApplicationFetchedListItem
import dev.yaaum.presentation.feature.main.screen.main.item.loading.ApplicationLoadingListItem

@Composable
fun LimitedApplicationListBlock(
    modifier: Modifier = Modifier,
    list: List<TimeUsageUiModel>?,
    onMoreClick: (() -> Unit)? = null,
    onPermissionClick: (() -> Unit)? = null,
    onApplicationClick: ((TimeUsageUiModel) -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = UiText
                    .StringResource(dev.yaaum.presentation.core.localisation.R.string.main_top_apps_title)
                    .asString(LocalContext.current),
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
                icon = R.drawable.icon_caret_right_bold_24,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                defaultBackgroundColor = YaaumTheme.colors.primary,
                pressedBackgroundColor = YaaumTheme.colors.secondary,
                iconSize = YaaumTheme.icons.extraSmall,
                onClick = {
                    onMoreClick?.invoke()
                },
            )
        }
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.small))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(YaaumTheme.spacing.small),
        ) {
            when {
                (list == null) ->
                    @Suppress("MagicNumber")
                    repeat(3) {
                        ApplicationLoadingListItem()
                    }

                (list.isEmpty()) ->
                    NoPermissionItem(
                        onPermissionClick = onPermissionClick,
                    )

                else ->
                    repeat(list.size) {
                        val item = list[it]
                        ApplicationFetchedListItem(
                            timeUsageUiModel = item,
                            onApplicationClick = onApplicationClick,
                        )
                    }
            }
        }
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.small))
        YaaumCircleButton(
            icon = R.drawable.icon_info_bold_24,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            // TODO: fix
            iconSize = 16.dp,
            onClick = {
                onMoreClick?.invoke()
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListBlock_Dark() {
    YaaumTheme(useDarkTheme = true) {
        LimitedApplicationListBlock(
            list = emptyList(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListBlock_Light() {
    YaaumTheme(useDarkTheme = false) {
        LimitedApplicationListBlock(
            list = emptyList(),
        )
    }
}
