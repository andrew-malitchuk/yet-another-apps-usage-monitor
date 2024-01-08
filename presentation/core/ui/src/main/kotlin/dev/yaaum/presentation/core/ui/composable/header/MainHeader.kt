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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.HealthStatus
import dev.yaaum.presentation.core.models.HealthStatusUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.composable.ext.placeholder
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * Main type of header; contains back, action buttons and title
 *
 * @param modifier
 * @param icon icon to set
 * @param healthStatus display icon which depends on health status
 * @param onClick lambda
 */
@Suppress("LongMethod")
// TODO: recode me
@Composable
fun MainHeader(
    modifier: Modifier = Modifier,
    @DrawableRes
    icon: Int,
    healthStatus: HealthStatusUiModel?,
    onClick: (() -> Unit)? = null,
) {
    when (healthStatus) {
        null ->
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(YaaumTheme.colors.background)
                    .padding(vertical = YaaumTheme.spacing.small),
            ) {
                Box(
                    modifier = Modifier
                        .size(YaaumTheme.icons.medium)
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                        .align(Alignment.CenterVertically)
                        .background(YaaumTheme.colors.secondary)
                        .placeholder(
                            backgroundColor = YaaumTheme.colors.surface,
                            isLoading = true,
                            shape = RoundedCornerShape(YaaumTheme.corners.medium),
                        ),
                ) {
                    Image(
                        colorFilter = ColorFilter.tint(YaaumTheme.colors.onPrimary),
                        painter = painterResource(id = R.drawable.icon_fire_bold_24),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                            .padding(YaaumTheme.spacing.small),
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                YaaumCircleButton(
                    icon = icon,
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    defaultBackgroundColor = YaaumTheme.colors.primary,
                    pressedBackgroundColor = YaaumTheme.colors.secondary,
                    iconSize = YaaumTheme.icons.smallMedium,
                    onClick = {
                        onClick?.invoke()
                    },
                )
            }

        else -> {
            val iconHealth = when (healthStatus?.status) {
                HealthStatus.NERVOUS -> R.drawable.icon_smiley_nervous_bold_24
                HealthStatus.SMILEY -> R.drawable.icon_smiley_bold_24
                HealthStatus.ANGRY -> R.drawable.icon_smiley_angry_bold_24
                HealthStatus.BLANK -> R.drawable.icon_smiley_blank_bold_24
                HealthStatus.MEH -> R.drawable.icon_smiley_meh_bold_24
                HealthStatus.SAD -> R.drawable.icon_smiley_sad_bold_24
                HealthStatus.WINK -> R.drawable.icon_smiley_wink_bold_24
                HealthStatus.DAMN -> R.drawable.icon_smiley_x_eyes_bold_24
                else -> R.drawable.icon_info_bold_24
            }

            val titleHealth = UiText.StringResource(
                when (healthStatus.status) {
                    HealthStatus.NERVOUS -> dev.yaaum.presentation.core.localisation.R.string.health_status_nervous
                    HealthStatus.SMILEY -> dev.yaaum.presentation.core.localisation.R.string.health_status_smiley
                    HealthStatus.ANGRY -> dev.yaaum.presentation.core.localisation.R.string.health_status_angry
                    HealthStatus.BLANK -> dev.yaaum.presentation.core.localisation.R.string.health_status_blank
                    HealthStatus.MEH -> dev.yaaum.presentation.core.localisation.R.string.health_status_meh
                    HealthStatus.SAD -> dev.yaaum.presentation.core.localisation.R.string.health_status_sad
                    HealthStatus.WINK -> dev.yaaum.presentation.core.localisation.R.string.health_status_wink
                    HealthStatus.DAMN -> dev.yaaum.presentation.core.localisation.R.string.health_status_damn
                    else -> dev.yaaum.presentation.core.localisation.R.string.health_status_blank
                },
            ).asString(LocalContext.current)

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(YaaumTheme.colors.background)
                    .padding(vertical = YaaumTheme.spacing.small),
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
                    text = titleHealth,
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
                    iconSize = YaaumTheme.icons.smallMedium,
                    onClick = {
                        onClick?.invoke()
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_MainHeader_Fetched_Dark() {
    YaaumTheme(useDarkTheme = true) {
        @Suppress("MagicNumber")
        MainHeader(
            icon = R.drawable.icon_gear_six_bold_24,
            healthStatus = HealthStatusUiModel(
                10f,
                HealthStatus.WINK,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_MainHeader_Fetched_Light() {
    YaaumTheme(useDarkTheme = false) {
        MainHeader(
            icon = R.drawable.icon_gear_six_bold_24,
            healthStatus = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_MainHeader_Loading_Dark() {
    YaaumTheme(useDarkTheme = true) {
        @Suppress("MagicNumber")
        MainHeader(
            icon = R.drawable.icon_gear_six_bold_24,
            healthStatus = HealthStatusUiModel(
                10f,
                HealthStatus.WINK,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_MainHeader_Loading_Light() {
    YaaumTheme(useDarkTheme = false) {
        MainHeader(
            icon = R.drawable.icon_gear_six_bold_24,
            healthStatus = null,
        )
    }
}
