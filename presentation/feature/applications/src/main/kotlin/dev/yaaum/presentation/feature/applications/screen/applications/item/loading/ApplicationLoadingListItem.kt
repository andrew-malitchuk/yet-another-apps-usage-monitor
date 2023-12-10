package dev.yaaum.presentation.feature.applications.screen.applications.item.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.composable.ext.placeholder
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun ApplicationLoadingListItem(
    modifier: Modifier = Modifier,
) {
    val faker = Faker()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.surface)
            .placeholder(
                backgroundColor = YaaumTheme.colors.surface,
                isLoading = true,
                shape = RoundedCornerShape(YaaumTheme.corners.medium),
            )
            .padding(YaaumTheme.spacing.small)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { },
            ),
    ) {
        Box(
            modifier = Modifier
                .size(YaaumTheme.icons.medium)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                .align(Alignment.CenterVertically)
                .background(YaaumTheme.colors.secondary),
        )
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
        Column(
            modifier = Modifier,
        ) {
            Text(
                text = faker.quote.fortuneCookie(),
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.extraSmall))
            Text(
                text = faker.quote.fortuneCookie(),
                style = YaaumTheme.typography.caption,
                color = YaaumTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationLoadingListItem_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationLoadingListItem()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationLoadingListItem_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationLoadingListItem()
    }
}
