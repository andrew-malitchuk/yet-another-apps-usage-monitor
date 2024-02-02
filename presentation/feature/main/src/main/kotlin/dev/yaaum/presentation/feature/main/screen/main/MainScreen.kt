package dev.yaaum.presentation.feature.main.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.composable.dialog.YaaumBottomSheetDialog
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.dialog.GeneralHealthInfoContent
import dev.yaaum.presentation.feature.main.dialog.HealthSummaryInfoContent
import dev.yaaum.presentation.feature.main.dialog.RecommendationInfoContent
import dev.yaaum.presentation.feature.main.dialog.TopAppsInfoContent
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.main.screen.main.content.fetched.FetchedContent
import dev.yaaum.presentation.feature.main.screen.main.mvi.MainMvi

@Suppress("LongMethod")
// TODO: fix
@Composable
fun MainScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    mainMvi: MainMvi,
) {
    @Suppress("UnusedPrivateProperty")
    val mainScreen = rememberScreen(RouteGraph.MainScreen)
    val theme by hostViewModel.currentThemeUiModel.collectAsState()

    val state by mainMvi.state.collectAsState()
    val effect by mainMvi.effect.collectAsState(null)

    val settingsScreen = rememberScreen(RouteGraph.SettingsScreen)
    val applicationsScreen = rememberScreen(RouteGraph.ApplicationsScreen)
    val permissionsScreen = rememberScreen(RouteGraph.PermissionsScreen)
    val healthScreen = rememberScreen(RouteGraph.HealthScreen)
    val applicationDetalizationScreen = rememberScreen(
        RouteGraph.ApplicationDetalizationScreen("foo"),
    )

    var showGeneralHealth by remember { mutableStateOf(false) }
    var showTopApps by remember { mutableStateOf(false) }
    var showRecommendation by remember { mutableStateOf(false) }
    var showHealthSummary by remember { mutableStateOf(false) }

    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "theme" to theme,
            "state" to state,
            "effect" to effect,
        ),
    )

    if (showGeneralHealth) {
        YaaumBottomSheetDialog(
            onDismiss = {
                showGeneralHealth = false
            },
        ) {
            GeneralHealthInfoContent(
                onDismiss = {
                    showGeneralHealth = false
                },
            )
        }
    }
    if (showTopApps) {
        YaaumBottomSheetDialog(
            onDismiss = {
                showTopApps = false
            },
        ) {
            TopAppsInfoContent(
                onDismiss = {
                    showTopApps = false
                },
            )
        }
    }
    if (showRecommendation) {
        YaaumBottomSheetDialog(
            onDismiss = {
                showRecommendation = false
            },
        ) {
            RecommendationInfoContent(
                onDismiss = {
                    showRecommendation = false
                },
            )
        }
    }
    if (showHealthSummary) {
        YaaumBottomSheetDialog(
            onDismiss = {
                showHealthSummary = false
            },
        ) {
            HealthSummaryInfoContent(
                onDismiss = {
                    showHealthSummary = false
                },
            )
        }
    }

    YaaumTheme(theme = theme) {
        FetchedContent(
            state = state,
            onSettingsClick = {
                navigator.push(settingsScreen)
            },
            onMoreClick = {
                navigator.push(applicationsScreen)
            },
            onAppsInfoClick = {
                showTopApps = true
            },
            onHealthClick = {
                navigator.push(healthScreen)
            },
            onHealthStatusClick = {
                showGeneralHealth = true
            },
            onApplicationClick = {
                navigator.push(applicationDetalizationScreen)
            },
            onPermissionClick = {
                navigator.push(permissionsScreen)
            },
            onHealthInfoClick = {
                showHealthSummary = true
            },
            onRecommendationInfoClick = {
                showRecommendation = true
            },
        )
    }
}
