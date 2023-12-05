package dev.yaaum.presentation.feature.applications.screen.detalization

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.ui.composable.content.loading.DefaultLoadingContent
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.applications.screen.detalization.content.fetched.ApplicationDetalizationFetchedContent
import dev.yaaum.presentation.feature.applications.screen.detalization.mvi.ApplicationDetalizationMvi
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedParameter", "UnusedPrivateProperty")
fun ApplicationDetalizationScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    applicationDetalizationMvi: ApplicationDetalizationMvi,
) {
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false

    val state by applicationDetalizationMvi.state.collectAsState()
    val effect by applicationDetalizationMvi.effect.collectAsState(null)

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "applicationDetalizationMvi" to applicationDetalizationMvi,
            "isDarkMode" to isDarkMode,
            "state" to state,
            "effect" to effect,
        ),
    )

    YaaumTheme(isDarkMode) {
        when (state.partialState) {
            MviPartialState.FETCHED -> ApplicationDetalizationFetchedContent(state = state)
            else -> DefaultLoadingContent()
        }
    }
}
