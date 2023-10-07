package dev.yaaum.presentation.feature.main.screen.composable.main.content.fetched.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumDefaultCircleButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.composable.main.content.fetched.list.ApplicationListItem
import io.github.serpro69.kfaker.Faker

@Composable
fun LimitedListBlock(
    title: String,
    list: List<String>,
    onMoreClick: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = title,
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
            )
            Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
            YaaumDefaultCircleButton(
                modifier = Modifier
                    // TODO: fix
                    .size(32.dp)
                    .align(Alignment.CenterVertically),
                icon = ImageVector.vectorResource(id = R.drawable.icon_caret_right_bold_24),
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
            repeat(list.size) {
                ApplicationListItem(
                    title = Faker().quote.fortuneCookie(),
                    description = Faker().quote.fortuneCookie(),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListBlock_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        LimitedListBlock(
            title = faker.quote.fortuneCookie(),
            listOf("foo", "bar", "foobar"),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListBlock_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        LimitedListBlock(
            title = faker.quote.fortuneCookie(),
            listOf("foo", "bar", "foobar"),
        )
    }
}
