package dev.yaaum.presentation.feature.settings.screen.about

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.ext.openLinkInBrowser
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.ui.composable.content.error.DefaultErrorContent
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.screen.about.content.fetched.AboutFetchedContent
import dev.yaaum.presentation.feature.settings.screen.about.mvi.AboutMvi
import dev.yaaum.presentation.feature.settings.screen.about.mvi.AboutMviEffect

@Composable
fun AboutScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    aboutMvi: AboutMvi,
) {
    val demoScreen = rememberScreen(RouteGraph.DemoScreen)
    val theme by hostViewModel.currentThemeUiModel.collectAsState()

    val state by aboutMvi.state.collectAsState()
    val effect by aboutMvi.effect.collectAsState(null)

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "aboutMvi" to aboutMvi,
            "demoScreen" to demoScreen,
            "theme" to theme,
        ),
    )
    YaaumTheme(theme = theme) {
        when (state.partialState) {
            MviPartialState.FETCHED -> AboutFetchedContent(
                onGithubClick = {
                    aboutMvi.sendEffect(AboutMviEffect.GoToGithubMviEffect)
                },
                onDemoClick = {
                    aboutMvi.sendEffect(AboutMviEffect.GoToDemoMviEffect)
                },
            )

            else -> DefaultErrorContent(error = null)
        }
    }
    when (effect) {
        AboutMviEffect.GoToDemoMviEffect ->
            navigator.push(demoScreen)

        AboutMviEffect.GoToGithubMviEffect ->
            LocalContext.current.openLinkInBrowser(
                url = AboutMvi.GITHUB_URL,
            )

        null -> Unit
    }
}
