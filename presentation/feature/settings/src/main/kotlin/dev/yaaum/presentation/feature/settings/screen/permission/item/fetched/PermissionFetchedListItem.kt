package dev.yaaum.presentation.feature.settings.screen.permission.item.fetched

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.toggle.YaaumSwitchButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun PermissionFetchedListItem(
    permission: String,
    @DrawableRes
    icon: Int,
    onPermissionClick: ((Boolean) -> Unit)? = null,
    initValue: Boolean,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.surface)
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
            Image(
                painter = painterResource(id = icon),
                colorFilter = ColorFilter.tint(YaaumTheme.colors.onSurface),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(YaaumTheme.spacing.small),
            )
        }
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
        Text(
            text = permission,
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f),
        )
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
        // TODO fix
        YaaumSwitchButton(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            width = 48.dp,
            height = 32.dp,
            thumbSize = 16.dp,
            initValue = initValue,
            foo = initValue,
            onStateChange = onPermissionClick,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionFetchedListItem_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        PermissionFetchedListItem(
            permission = faker.quote.fortuneCookie(),
            icon = R.drawable.icon_fire_bold_24,
            initValue = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionFetchedListItem_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        PermissionFetchedListItem(
            permission = faker.quote.fortuneCookie(),
            icon = R.drawable.icon_fire_bold_24,
            initValue = false,
        )
    }
}
