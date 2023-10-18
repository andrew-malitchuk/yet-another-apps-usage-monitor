package dev.yaaum.presentation.core.ui.composable.button.swipe

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun YaaumDoubleSideButton(
    modifier: Modifier = Modifier,
    sideA: Int,
    sideB: Int,
    onSideChange: ((Boolean) -> Unit)? = null,
) {
    var onSideChangeState by remember {
        mutableStateOf(true)
    }
    Box(
        modifier = modifier
            // TODO: fix
            .size(64.dp)
            .clickable {
                onSideChangeState = onSideChangeState.not()
                onSideChange?.invoke(onSideChangeState)
            }
            // TODO: fix
            .clip(RoundedCornerShape(YaaumTheme.corners.medium))
            .background(YaaumTheme.colors.primary)
            // TODO: fix
            .padding(8.dp),
    ) {
        if (onSideChangeState) {
            Icon(
                painter = painterResource(id = sideA),
                contentDescription = null,
                tint = YaaumTheme.colors.background,
                modifier = Modifier
                    .align(Alignment.Center),
            )
        } else {
            Icon(
                painter = painterResource(id = sideB),
                contentDescription = null,
                tint = YaaumTheme.colors.background,
                modifier = Modifier
                    .align(Alignment.Center),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Foo_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumDoubleSideButton(
            sideA = R.drawable.icon_fire_bold_24,
            sideB = R.drawable.icon_plus_bold_24,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Foo_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumDoubleSideButton(
            sideA = R.drawable.icon_fire_bold_24,
            sideB = R.drawable.icon_plus_bold_24,
        )
    }
}
