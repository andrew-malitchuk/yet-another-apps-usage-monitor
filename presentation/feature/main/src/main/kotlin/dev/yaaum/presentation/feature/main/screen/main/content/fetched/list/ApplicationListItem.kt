package dev.yaaum.presentation.feature.main.screen.main.content.fetched.list

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.item.YaaumBaseListContainer
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun ApplicationListItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onClick: (() -> Unit)? = null,
) {
    YaaumBaseListContainer(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = {
            onClick?.invoke()
        },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
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
                    painter = painterResource(id = R.drawable.icon_fire_bold_24),
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
                    text = title,
                    style = YaaumTheme.typography.title,
                    color = YaaumTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(YaaumTheme.spacing.extraSmall))
                Text(
                    text = description,
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
fun Preview_ApplicationListItem_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        ApplicationListItem(
            title = faker.quote.fortuneCookie(),
            description = faker.quote.fortuneCookie(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListItem_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        ApplicationListItem(
            title = faker.quote.fortuneCookie(),
            description = faker.quote.fortuneCookie(),
        )
    }
}
