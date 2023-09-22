package dev.yaaum.presentation.feature.main.screen.composable.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

@Composable
fun MainScreen(
    navigator: Navigator,
    from: String,
) {
    val settingsScreen = rememberScreen(RouteGraph.SettingsScreen)

    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Text(text = "Main: from: $from")
            Button(onClick = {
                navigator.push(settingsScreen)
            }) {
                Text(text = "settings")
            }
        }
    }
}
