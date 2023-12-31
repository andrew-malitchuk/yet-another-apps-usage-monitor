package dev.yaaum.presentation.feature.main.screen.main.content.fetched.list

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.item.YaaumBaseListContainer
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun NoPermissionItem(
    modifier: Modifier = Modifier,
    onPermissionClick: (() -> Unit)? = null,
) {
    YaaumBaseListContainer(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = {
            onPermissionClick?.invoke()
        },
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
                    painter = painterResource(id = R.drawable.icon_chart_pie_slice_bold_24),
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
                text = UiText
                    .StringResource(dev.yaaum.presentation.core.localisation.R.string.main_no_usage_permission)
                    .asString(LocalContext.current),
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_NoPermissionItem_Dark() {
    YaaumTheme(useDarkTheme = true) {
        NoPermissionItem()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_NoPermissionItem_Light() {
    YaaumTheme(useDarkTheme = false) {
        NoPermissionItem()
    }
}
