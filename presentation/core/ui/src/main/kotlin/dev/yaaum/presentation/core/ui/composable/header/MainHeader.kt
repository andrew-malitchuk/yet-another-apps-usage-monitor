package dev.yaaum.presentation.core.ui.composable.header

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
import dev.yaaum.presentation.core.models.HealthSimplifiedUiModel
import dev.yaaum.presentation.core.models.HealthStatus
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

/**
 * Main type of header; contains back, action buttons and title
 *
 * @param modifier
 * @param icon icon to set
 * @param healthStatus display icon which depends on health status
 * @param onClick lambda
 */
@Composable
fun MainHeader(
    modifier: Modifier = Modifier,
    @DrawableRes
    icon: Int,
    healthStatus: HealthSimplifiedUiModel,
    onClick: (() -> Unit)? = null,
) {
    val iconHealth = when (healthStatus.status) {
        HealthStatus.NERVOUS -> R.drawable.icon_smiley_nervous_bold_24
        HealthStatus.SMILEY -> R.drawable.icon_smiley_bold_24
        HealthStatus.ANGRY -> R.drawable.icon_smiley_angry_bold_24
        HealthStatus.BLANK -> R.drawable.icon_smiley_blank_bold_24
        HealthStatus.MEH -> R.drawable.icon_smiley_meh_bold_24
        HealthStatus.SAD -> R.drawable.icon_smiley_sad_bold_24
        HealthStatus.WINK -> R.drawable.icon_smiley_wink_bold_24
        HealthStatus.DAMN -> R.drawable.icon_smiley_x_eyes_bold_24
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background)
            .padding(vertical = YaaumTheme.spacing.small),
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
                colorFilter = ColorFilter.tint(YaaumTheme.colors.onPrimary),
                painter = painterResource(id = iconHealth),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(YaaumTheme.spacing.small),
            )
        }
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f),
            text = healthStatus.title,
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onBackground,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = Modifier.width(YaaumTheme.spacing.small))
        YaaumCircleButton(
            icon = icon,
            modifier = Modifier
                .align(Alignment.CenterVertically),
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            // TODO: fix
            iconSize = 32.dp,
            onClick = {
                onClick?.invoke()
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_MainHeader_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        MainHeader(
            icon = R.drawable.icon_gear_six_bold_24,
            healthStatus = HealthSimplifiedUiModel(
                HealthStatus.WINK,
                faker.quote.fortuneCookie(),
                faker.quote.fortuneCookie(),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_MainHeader_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        MainHeader(
            icon = R.drawable.icon_gear_six_bold_24,
            healthStatus = HealthSimplifiedUiModel(
                HealthStatus.WINK,
                faker.quote.fortuneCookie(),
                faker.quote.fortuneCookie(),
            ),
        )
    }
}
