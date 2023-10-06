package dev.yaaum.presentation.core.ui.composable.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumDefaultCircleButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun SimpleHeader(
    icon: ImageVector,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background)
            .padding(vertical = YaaumTheme.spacing.small),
    ) {
        YaaumDefaultCircleButton(
            modifier = Modifier
                .align(Alignment.CenterEnd),
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
    YaaumTheme(useDarkTheme = true) {
        SimpleHeader(
            icon = ImageVector.vectorResource(R.drawable.icon_gear_six_bold_24),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_SimpleHeader_Light() {
    YaaumTheme(useDarkTheme = false) {
        SimpleHeader(
            icon = ImageVector.vectorResource(R.drawable.icon_gear_six_bold_24),
        )
    }
}
