package dev.yaaum.presentaion.feature.onboarding.screen.composable.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

@Composable
fun OnboardingScreen(
    navigator: Navigator,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen(from = "onboarding"))

    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme() {
        Column(
            modifier = Modifier
                .background(
                    color = Color.Cyan,
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
