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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.models.HealthSimplifiedUiModel
import dev.yaaum.presentation.core.models.HealthStatus
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun SimplifiedHealthCard(
    modifier: Modifier = Modifier,
    healthStatus: HealthSimplifiedUiModel,
) {
    val icon = when (healthStatus.status) {
        HealthStatus.NERVOUS -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_nervous_bold_24
        HealthStatus.SMILEY -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_bold_24
        HealthStatus.ANGRY -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_angry_bold_24
        HealthStatus.BLANK -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_blank_bold_24
        HealthStatus.MEH -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_meh_bold_24
        HealthStatus.SAD -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_sad_bold_24
        HealthStatus.WINK -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_wink_bold_24
        HealthStatus.DAMN -> dev.yaaum.presentation.core.ui.R.drawable.icon_smiley_x_eyes_bold_24
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.surface)
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
        Column(
            modifier = Modifier,
        ) {
            Text(
                text = healthStatus.title,
                style = YaaumTheme.typography.title,
                color = YaaumTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(YaaumTheme.spacing.extraSmall))
            Text(
                text = healthStatus.description,
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
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        SimplifiedHealthCard(
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
fun Preview_SimplifiedHealthCard_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        SimplifiedHealthCard(
            healthStatus = HealthSimplifiedUiModel(
                HealthStatus.WINK,
                faker.quote.fortuneCookie(),
                faker.quote.fortuneCookie(),
            ),
        )
    }
}
