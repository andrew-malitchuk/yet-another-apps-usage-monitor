package dev.yaaum.presentation.feature.settings.screen.about

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.screen.about.content.fetched.AboutFetchedContent

@Composable
fun AboutScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    @Suppress("unused")
    aboutViewModel: AboutViewModel,
) {
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "aboutViewModel" to aboutViewModel,
            "isDarkMode" to isDarkMode,
        ),
    )
    YaaumTheme(isDarkMode) {
        AboutFetchedContent()
    }
}
