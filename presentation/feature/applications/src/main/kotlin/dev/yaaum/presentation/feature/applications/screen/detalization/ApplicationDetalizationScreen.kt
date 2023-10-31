package dev.yaaum.presentation.feature.applications.screen.detalization

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.applications.screen.detalization.content.fetched.ApplicationDetalizationFetchedContent
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedParameter", "UnusedPrivateProperty")
fun ApplicationDetalizationScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    @Suppress("unused")
    applicationDetalizationViewModel: ApplicationDetalizationViewModel,
) {
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "applicationDetalizationViewModel" to applicationDetalizationViewModel,
            "isDarkMode" to isDarkMode,
        ),
    )
    YaaumTheme(isDarkMode) {
        ApplicationDetalizationFetchedContent()
    }
}
