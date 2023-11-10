package dev.yaaum.presentation.core.ui.composable.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumDefaultCircleButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun SimpleHeader(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background)
            .padding(vertical = YaaumTheme.spacing.small),
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f),
            text = title,
            style = YaaumTheme.typography.headline,
            color = YaaumTheme.colors.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.extraSmall))
        YaaumDefaultCircleButton(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            icon = icon,
            onClick = {
                onClick?.invoke()
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_SimpleHeader_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        SimpleHeader(
            icon = ImageVector.vectorResource(R.drawable.icon_gear_six_bold_24),
            title = faker.quote.fortuneCookie(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_SimpleHeader_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        SimpleHeader(
            icon = ImageVector.vectorResource(R.drawable.icon_gear_six_bold_24),
            title = faker.quote.fortuneCookie(),
        )
    }
}
