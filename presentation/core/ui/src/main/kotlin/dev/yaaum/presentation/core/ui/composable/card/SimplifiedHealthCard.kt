package dev.yaaum.presentation.core.ui.composable.card

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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.HealthStatus
import dev.yaaum.presentation.core.models.HealthStatusUiModel
import dev.yaaum.presentation.core.ui.composable.ext.placeholder
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * Simplified health card
 */
@Composable
fun SimplifiedHealthCard(
    modifier: Modifier = Modifier,
    healthStatus: HealthStatusUiModel?,
) {
    val icon = when (healthStatus?.status) {
        HealthStatus.NERVOUS -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_nervous_bold_24
        HealthStatus.SMILEY -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_bold_24
        HealthStatus.ANGRY -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_angry_bold_24
        HealthStatus.BLANK -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_blank_bold_24
        HealthStatus.MEH -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_meh_bold_24
        HealthStatus.SAD -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_sad_bold_24
        HealthStatus.WINK -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_wink_bold_24
        else -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_x_eyes_bold_24
    }

    val titleHealth = UiText.StringResource(
        when (healthStatus?.status) {
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
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.surface)
            .placeholder(
                backgroundColor = YaaumTheme.colors.surface,
                isLoading = healthStatus == null,
                shape = RoundedCornerShape(YaaumTheme.corners.medium),
            )
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
                colorFilter = ColorFilter.tint(YaaumTheme.colors.onPrimary),
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
                text = UiText
                    .StringResource(dev.yaaum.presentation.core.localisation.R.string.health_month)
                    .asString(LocalContext.current),
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.extraSmall))
            Text(
                text = titleHealth,
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
fun Preview_SimplifiedHealthCard_Dark() {
    YaaumTheme(useDarkTheme = true) {
        @Suppress("MagicNumber")
        SimplifiedHealthCard(
            healthStatus = HealthStatusUiModel(
                10f,
                HealthStatus.BLANK,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_SimplifiedHealthCard_Light() {
    YaaumTheme(useDarkTheme = false) {
        @Suppress("MagicNumber")
        SimplifiedHealthCard(
            healthStatus = HealthStatusUiModel(
                10f,
                HealthStatus.BLANK,
            ),
        )
    }
}
