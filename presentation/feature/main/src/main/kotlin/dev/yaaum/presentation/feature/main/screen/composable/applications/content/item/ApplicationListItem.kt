package dev.yaaum.presentation.feature.main.screen.composable.applications.content.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun ApplicationListItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.surface),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            // TODO: add sizes
            Image(
                Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(26.dp),
                alignment = Alignment.CenterStart,
            )
            Spacer(modifier = Modifier.width(YaaumTheme.spacing.medium))
            Column(
                modifier = Modifier,
            ) {
                Text(
                    text = "display",
                    style = YaaumTheme.typography.display,
                    color = YaaumTheme.colors.onSurface,
                )
                Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
                Text(
                    text = "title",
                    style = YaaumTheme.typography.title,
                    color = YaaumTheme.colors.onSurface,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListItem_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationListItem()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationListItem_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationListItem()
    }
}
