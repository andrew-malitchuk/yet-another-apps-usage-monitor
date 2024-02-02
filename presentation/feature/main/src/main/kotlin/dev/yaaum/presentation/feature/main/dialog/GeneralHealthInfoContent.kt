package dev.yaaum.presentation.feature.main.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.R
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.composable.various.AnimatedDivider
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.main.item.fetched.HealthFetchedListItem

@Suppress("LongMethod")
@Composable
fun GeneralHealthInfoContent(
    modifier: Modifier = Modifier,
    onDismiss: (() -> Unit)? = null,
) {
    val lazyScrollState = rememberLazyListState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background)
            .padding(YaaumTheme.spacing.medium),
    ) {
        Text(
            text = UiText
                .StringResource(R.string.main_health_general_dialog_title)
                .asString(LocalContext.current),
            style = YaaumTheme.typography.display,
            color = YaaumTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
        Text(
            text = UiText
                .StringResource(R.string.main_health_general_dialog_description)
                .asString(LocalContext.current),
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
        AnimatedDivider(
            state = lazyScrollState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(YaaumTheme.colors.background),
            state = lazyScrollState,
            verticalArrangement = Arrangement
                .spacedBy(YaaumTheme.spacing.small),
        ) {
            item {
                HealthFetchedListItem(
                    title = R.string.health_status_nervous,
                    icon = dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_nervous_bold_24,
                )
            }
            item {
                HealthFetchedListItem(
                    title = R.string.health_status_smiley,
                    icon = dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_bold_24,
                )
            }
            item {
                HealthFetchedListItem(
                    title = R.string.health_status_angry,
                    icon = dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_angry_bold_24,
                )
            }
            item {
                HealthFetchedListItem(
                    title = R.string.health_status_blank,
                    icon = dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_blank_bold_24,
                )
            }
            item {
                HealthFetchedListItem(
                    title = R.string.health_status_meh,
                    icon = dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_meh_bold_24,
                )
            }
            item {
                HealthFetchedListItem(
                    title = R.string.health_status_sad,
                    icon = dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_sad_bold_24,
                )
            }
            item {
                HealthFetchedListItem(
                    title = R.string.health_status_wink,
                    icon = dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_wink_bold_24,
                )
            }
            item {
                HealthFetchedListItem(
                    title = R.string.health_status_damn,
                    icon = dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_x_eyes_bold_24,
                )
            }
            item {
                HealthFetchedListItem(
                    title = R.string.health_status_blank,
                    icon = dev.yaaum.presentation.core.ui.R.drawable.icon_info_bold_24,
                )
            }
        }
        AnimatedDivider(
            state = lazyScrollState,
            isInverted = true,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
        YaaumOrdinaryButton(
            title = UiText.StringResource(R.string.various_ok)
                .asString(LocalContext.current),
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            onClick = {
                onDismiss?.invoke()
            },
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_GeneralHealthInfoContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        GeneralHealthInfoContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_GeneralHealthInfoContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        GeneralHealthInfoContent()
    }
}
