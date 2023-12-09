package dev.yaaum.presentation.feature.health.screen.health

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.platform.mvi.MviPartialState
import dev.yaaum.presentation.core.ui.composable.content.error.DefaultErrorContent
import dev.yaaum.presentation.core.ui.composable.content.loading.DefaultLoadingContent
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.health.screen.health.content.fetched.HealthFetchedContent
import dev.yaaum.presentation.feature.health.screen.health.mvi.HealthMvi
import dev.yaaum.presentation.feature.health.screen.health.mvi.HealthMviEffect
import dev.yaaum.presentation.feature.main.screen.HostViewModel

@Composable
@Suppress("UnusedPrivateProperty")
fun HealthScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    healthMvi: HealthMvi,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val theme by hostViewModel.currentThemeUiModel.collectAsState()
    val applicationsScreen = rememberScreen(RouteGraph.ApplicationsScreen)

    val state by healthMvi.state.collectAsState()
    val effect by healthMvi.effect.collectAsState(null)

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "healthMvi" to healthMvi,
            "mainScreen" to mainScreen,
            "theme" to theme,
            "applicationsScreen" to applicationsScreen,
            "state" to state,
            "effect" to effect,
        ),
    )
    YaaumTheme(theme = theme) {
        when (state.partialState) {
            MviPartialState.FETCHED -> HealthFetchedContent(
                state = state,
                onActionClick = {
                    navigator.push(applicationsScreen)
                },
                onApplicationClick = { application ->
                    application.packageName?.let {
                        healthMvi.sendEffect(
                            HealthMviEffect.OpenApplicationDetalizationMviEffect(
                                packageName = it,
                            ),
                        )
                    }
                },
            )

            MviPartialState.LOADING -> DefaultLoadingContent()
            // TODO: fix me
            else -> DefaultErrorContent(error = null)
        }
    }

    when (effect) {
        is HealthMviEffect.OpenApplicationDetalizationMviEffect ->
            navigator.push(
                rememberScreen(
                    RouteGraph.ApplicationDetalizationScreen(
                        packageName = (effect as HealthMviEffect.OpenApplicationDetalizationMviEffect).packageName,
                    ),
                ),
            )

        null -> {}
    }
}
