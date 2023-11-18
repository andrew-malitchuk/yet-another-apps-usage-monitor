package dev.yaaum.presentation.core.ui.composable.button.various

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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

/**
 * Button which displays theme according to [SelectedTheme]
 *
 * @param modifier
 * @param onThemeSelected lambda
 * @param preselectedTheme init theme
 */
@Composable
fun YaaumThemeButton(
    modifier: Modifier = Modifier,
    onThemeSelected: ((SelectedTheme) -> Unit)? = null,
    preselectedTheme: SelectedTheme? = null,
) {
    var onSideChangeState by remember {
        mutableStateOf(preselectedTheme)
    }
    Box(
        modifier = modifier
            // TODO: fix
            .size(48.dp)
            .clickable {
                onSideChangeState = (onSideChangeState ?: SelectedTheme.NI).next()
                onSideChangeState?.let { onThemeSelected?.invoke(it) }
            }
            // TODO: fix
            .clip(CircleShape)
            .background(YaaumTheme.colors.primary)
            // TODO: fix
            .padding(8.dp),
    ) {
        @Suppress("OptionalWhenBraces")
        when (onSideChangeState) {
            SelectedTheme.LIGHT -> {
                Icon(
                    painter = painterResource(id = R.drawable.icon_sun_regular_24),
                    contentDescription = null,
                    tint = YaaumTheme.colors.background,
                    modifier = Modifier
                        .align(Alignment.Center),
                )
            }

            SelectedTheme.DARK -> {
                Icon(
                    painter = painterResource(id = R.drawable.icon_moon_regular_24),
                    contentDescription = null,
                    tint = YaaumTheme.colors.background,
                    modifier = Modifier
                        .align(Alignment.Center),
                )
            }

            SelectedTheme.MATERIALU -> {
                Icon(
                    painter = painterResource(id = R.drawable.icon_palette_regular_24),
                    contentDescription = null,
                    tint = YaaumTheme.colors.background,
                    modifier = Modifier
                        .align(Alignment.Center),
                )
            }

            else -> {
                Icon(
                    painter = painterResource(id = R.drawable.icon_android_logo_regular_24),
                    contentDescription = null,
                    tint = YaaumTheme.colors.background,
                    modifier = Modifier
                        .align(Alignment.Center),
                )
            }
        }
    }
}

enum class SelectedTheme {
    LIGHT,
    DARK,
    AUTO,

    @Suppress("SpellCheckingInspection")
    MATERIALU,
    NI,
    ;

    fun next(): SelectedTheme {
        return when (this) {
            LIGHT -> DARK
            DARK -> AUTO
            AUTO -> MATERIALU
            MATERIALU -> LIGHT
            NI -> LIGHT
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ThemeButton_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumThemeButton()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ThemeButton_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumThemeButton()
    }
}
