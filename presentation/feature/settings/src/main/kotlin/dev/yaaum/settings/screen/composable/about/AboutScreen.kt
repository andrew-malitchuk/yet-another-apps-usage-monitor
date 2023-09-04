package dev.yaaum.settings.screen.composable.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.navigation.RouteGraph
import dev.yaaum.ui.theme.YaaumTheme

@Composable
fun AboutScreen(
    navigator: Navigator,
) {
    val mainScreen = rememberScreen(RouteGraph.MainScreen(from = "about"))

    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Text(text = "About")
            Button(onClick = {
                navigator.push(mainScreen)
            }) {
                Text(text = "Main")
            }
        }
    }
}
