package dev.yaaum.presentation.feature.settings.screen.settings

import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.localisation.LocalisationHelper
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.ui.composable.content.error.DefaultErrorContent
import dev.yaaum.presentation.core.ui.composable.content.loading.DefaultLoadingContent
import dev.yaaum.presentation.core.ui.composable.theme.CircularReveal
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.screen.settings.content.fetched.SettingsFetchedContent
import dev.yaaum.presentation.feature.settings.screen.settings.mvi.SettingsMvi
import dev.yaaum.presentation.feature.settings.screen.settings.mvi.SettingsMvi.Companion.ANIMATION_DURATION
import dev.yaaum.presentation.feature.settings.screen.settings.mvi.SettingsMviEffect
import dev.yaaum.presentation.feature.settings.screen.settings.mvi.SettingsMviEvent
import io.getstream.log.StreamLog
import io.getstream.log.streamLog

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
        initial = currentTheme,
    )

    StreamLog.streamLog {
        "currentTheme: $currentTheme | theme: $theme"
    }

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "settingsMvi" to settingsMvi,
            "mainScreen" to mainScreen,
            "permissionScreen" to permissionScreen,
            "aboutScreen" to aboutScreen,
            "currentTheme" to currentTheme,
            "theme" to theme,
            "state" to state,
            "effect" to effect,
        ),
    )

    CircularReveal(
        targetState = theme,
        animationSpec = tween(ANIMATION_DURATION),
    ) { circularTheme ->
        YaaumTheme(
            theme = circularTheme,
        ) {
            when (state.partialState) {
                MviPartialState.FETCHED -> SettingsFetchedContent(
                    onPermissionClick = {
                        settingsMvi.sendEffect(SettingsMviEffect.GoToPermissionsScreenMviEffect)
                    },
                    onInfoClick = {
//                        settingsMvi.sendEffect(SettingsMviEffect.GoToInfoScreenMviEffect)
                        LocalisationHelper().changeLang(LocalisationHelper.SupportedLang.UKR)
                    },
                    onBackClick = {
                        navigator.pop()
                    },
                    onThemeSelected = {
                        settingsMvi.sendEvent(SettingsMviEvent.ChangeThemeMviEvent(it.theme))
                    },
                    theme = circularTheme,
                )

                MviPartialState.LOADING -> DefaultLoadingContent()

                else -> DefaultErrorContent(error = null)
            }
        }
    }
    when (effect) {
        SettingsMviEffect.GoToLanguageScreenMviEffect -> Unit
        SettingsMviEffect.GoToPermissionsScreenMviEffect -> navigator.push(permissionScreen)
        SettingsMviEffect.GoToInfoScreenMviEffect -> navigator.push(aboutScreen)
        null -> Unit
    }
}
