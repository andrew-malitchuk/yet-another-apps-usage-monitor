package dev.yaaum.presentation.feature.health.screen.health.item

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.ui.composable.item.YaaumBaseListContainer
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

@Composable
fun ApplicationListItem(
    modifier: Modifier = Modifier,
    applicationsUiModel: ApplicationsUiModel,
    onApplicationClick: ((ApplicationsUiModel) -> Unit)? = null,
) {
    YaaumBaseListContainer(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = {
            onApplicationClick?.invoke(applicationsUiModel)
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
                    .size(YaaumTheme.icons.medium)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                    .align(Alignment.CenterVertically)
                    .background(YaaumTheme.colors.secondary),
            ) {
                val icon = applicationsUiModel.packageName?.let { pn ->
                    LocalContext.current.packageManager.getApplicationIcon(pn)
                }
                Image(
                    painter = rememberDrawablePainter(icon),
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
                    // TODO: fix
                    text = applicationsUiModel.applicationName ?: "SWW",
                    style = YaaumTheme.typography.title,
                    color = YaaumTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(YaaumTheme.spacing.extraSmall))
                Text(
                    // TODO: fix
                    text = applicationsUiModel.packageName ?: "SWW",
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
            applicationsUiModel = ApplicationsUiModel(
                uuid = 1,
                packageName = faker.quote.fortuneCookie(),
                applicationName = faker.quote.fortuneCookie(),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListItem_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        ApplicationListItem(
            applicationsUiModel = ApplicationsUiModel(
                uuid = 1,
                packageName = faker.quote.fortuneCookie(),
                applicationName = faker.quote.fortuneCookie(),
            ),
        )
    }
}
