package dev.yaaum.presentation.feature.main.screen.composable.main

import androidx.compose.runtime.Composable
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.composable.HostViewModel
import dev.yaaum.presentation.feature.main.screen.composable.main.content.fetched.FetchedContent

@Composable
fun MainScreen(
    hostViewModel: HostViewModel,
) {
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false

    Rebugger(
        trackMap = mapOf(
            "isDarkMode" to isDarkMode,
        ),
    )
    YaaumTheme(useDarkTheme = isDarkMode) {
//        ErrorContent(
//            "Lorem ipsum",
//            "Dolor sit amen"
//        )
        FetchedContent()
    }
}
