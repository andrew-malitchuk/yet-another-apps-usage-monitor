package dev.yaaum.main.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.navigation.RouteGraph
import dev.yaaum.ui.theme.YaaumTheme

@Composable
fun MainScreen(
    navigator: Navigator,
) {
    val onboardingScreen = rememberScreen(RouteGraph.OnboardingScreen)

    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme() {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            ClickableText(
                modifier = Modifier
                    .align(Alignment.Center),
                text = AnnotatedString(text = "Main"),
                onClick = {
                    navigator.push(onboardingScreen)
                },
            )
        }
    }
}
