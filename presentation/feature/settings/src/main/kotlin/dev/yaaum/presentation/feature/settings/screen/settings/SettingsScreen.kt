package dev.yaaum.presentation.feature.settings.screen.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.ThemeUiModel
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.ui.composable.content.error.DefaultErrorContent
import dev.yaaum.presentation.core.ui.composable.content.loading.DefaultLoadingContent
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.screen.settings.content.fetched.SettingsFetchedContent
import dev.yaaum.presentation.feature.settings.screen.settings.mvi.SettingsMvi
import dev.yaaum.presentation.feature.settings.screen.settings.mvi.SettingsMviEffect
import dev.yaaum.presentation.feature.settings.screen.settings.mvi.SettingsMviEvent

@Composable
fun SettingsScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    settingsMvi: SettingsMvi,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val permissionScreen = rememberScreen(RouteGraph.PermissionScreen)
    val aboutScreen = rememberScreen(RouteGraph.AboutScreen)

    val state by settingsMvi.state.collectAsState()
    val effect by settingsMvi.effect.collectAsState(null)

    val currentTheme by hostViewModel.currentThemeUiModel.collectAsState()

    val theme by settingsMvi.themeStateFlow.collectAsState(
        initial = currentTheme ?: ThemeUiModel.AUTO,
    )

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "settingsMvi" to settingsMvi,
            "mainScreen" to mainScreen,
            "permissionScreen" to permissionScreen,
            "aboutScreen" to aboutScreen,
            "theme" to theme,
            "state" to state,
            "effect" to effect,
        ),
    )

//    CircularReveal(
//        targetState = theme,
//        animationSpec = tween(500),
//    ) { theme ->
    YaaumTheme(
        theme = theme,
    ) {
        when (state.partialState) {
            MviPartialState.FETCHED -> SettingsFetchedContent(
                onPermissionClick = {
                    settingsMvi.sendEffect(SettingsMviEffect.GoToPermissionsScreenMviEffect)
                },
                onInfoClick = {
                    settingsMvi.sendEffect(SettingsMviEffect.GoToInfoScreenMviEffect)
                },
                onBackClick = {
                    navigator.pop()
                },
                onThemeSelected = {
                    settingsMvi.sendEvent(SettingsMviEvent.ChangeThemeMviEvent(it.theme))
                },
                theme = theme,
            )

            MviPartialState.LOADING -> DefaultLoadingContent()

            else -> DefaultErrorContent(error = null)
        }
    }
    when (effect) {
        SettingsMviEffect.GoToLanguageScreenMviEffect -> Unit
        SettingsMviEffect.GoToPermissionsScreenMviEffect -> navigator.push(permissionScreen)
        SettingsMviEffect.GoToInfoScreenMviEffect -> navigator.push(aboutScreen)
        null -> Unit
    }
}
