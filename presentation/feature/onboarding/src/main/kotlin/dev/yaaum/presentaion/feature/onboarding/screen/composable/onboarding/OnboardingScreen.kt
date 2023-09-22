package dev.yaaum.presentaion.feature.onboarding.screen.composable.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentaion.feature.onboarding.screen.OnboardingViewModel
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.composable.HostViewModel
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme as Theme

@Composable
fun OnboardingScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    @Suppress("unused")
    onboardingViewModel: OnboardingViewModel,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen(from = "onboarding"))

    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false

    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme(isDarkMode) {
        Column(
            modifier = Modifier
                .background(
                    color = Theme.colors.background,
                )
                .fillMaxSize(),
        ) {
            Text("onboarding")
            Button(onClick = {
                navigator.push(mainScreen)
            }) {
                Text(text = "main")
            }
        }
    }
}
