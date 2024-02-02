package dev.yaaum.presentation.feature.main.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.localisation.R
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Suppress("LongMethod")
@Composable
fun RecommendationInfoContent(
    modifier: Modifier = Modifier,
    onDismiss: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(YaaumTheme.colors.background)
            .padding(YaaumTheme.spacing.medium),
    ) {
        Text(
            text = UiText
                .StringResource(R.string.main_recommendation_dialog_title)
                .asString(LocalContext.current),
            style = YaaumTheme.typography.display,
            color = YaaumTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
        Text(
            text = UiText
                .StringResource(R.string.main_recommendation_dialog_description)
                .asString(LocalContext.current),
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onBackground,
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.largest))
        YaaumOrdinaryButton(
            title = UiText.StringResource(R.string.various_ok)
                .asString(LocalContext.current),
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            onClick = {
                onDismiss?.invoke()
            },
        )
        Spacer(modifier = Modifier.height(YaaumTheme.spacing.medium))
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_RecommendationInfoContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        RecommendationInfoContent()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_RecommendationInfoContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        RecommendationInfoContent()
    }
}
