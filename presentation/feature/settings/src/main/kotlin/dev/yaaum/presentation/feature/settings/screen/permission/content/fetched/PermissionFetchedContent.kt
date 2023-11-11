package dev.yaaum.presentation.feature.settings.screen.permission.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.header.SimpleHeader
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.settings.screen.permission.content.fetched.list.PermissionListItem
import io.github.serpro69.kfaker.Faker

@Composable
fun PermissionFetchedContent(
    onInfoClick: (() -> Unit)? = null,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background),
    ) {
        SimpleHeader(
            icon = R.drawable.icon_info_bold_24,
            onClick = onInfoClick,
            title = Faker().quote.fortuneCookie(),
            modifier = Modifier
                .padding(
                    start = YaaumTheme.spacing.medium,
                    end = YaaumTheme.spacing.medium,
                    top = YaaumTheme.spacing.medium,
                    bottom = YaaumTheme.spacing.small,
                ),
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false)
                .background(YaaumTheme.colors.background)
                .padding(horizontal = YaaumTheme.spacing.medium),
            verticalArrangement = Arrangement
                .spacedBy(YaaumTheme.spacing.small),
        ) {
            PermissionListItem(
                // TODO: fix
                permission = "Notification",
                icon = R.drawable.icon_notification_bold_24,
            )
            PermissionListItem(
                // TODO: fix
                permission = "Usage",
                icon = R.drawable.icon_chart_pie_slice_bold_24,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionFetchedContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        PermissionFetchedContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionFetchedContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        PermissionFetchedContent()
    }
}
