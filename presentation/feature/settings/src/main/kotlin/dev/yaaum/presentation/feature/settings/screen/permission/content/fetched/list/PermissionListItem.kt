package dev.yaaum.presentation.feature.settings.screen.permission.content.fetched.list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.button.toggle.YaaumSwitchButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun PermissionListItem(
    permission: String,
    @DrawableRes
    icon: Int,
    onPermissionClick: ((Boolean) -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.surface)
            .clickable {
                onPermissionClick?.invoke(true)
            }
            .padding(YaaumTheme.spacing.small),
    ) {
        // TODO: add sizes
        Box(
            modifier = Modifier
                .size(48.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                .align(Alignment.CenterVertically)
                .background(YaaumTheme.colors.secondary),
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(YaaumTheme.spacing.small),
            )
        }
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
        Text(
            // TODO: fix
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
        YaaumSwitchButton(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            width = 48.dp,
            height = 32.dp,
            thumbSize = 16.dp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionListItem_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        PermissionListItem(
            permission = faker.quote.fortuneCookie(),
            icon = dev.yaaum.presentation.core.ui.R.drawable.icon_fire_bold_24,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_PermissionListItem_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        PermissionListItem(
            permission = faker.quote.fortuneCookie(),
            icon = dev.yaaum.presentation.core.ui.R.drawable.icon_fire_bold_24,
        )
    }
}
