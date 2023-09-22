package dev.yaaum.presentation.feature.settings.screen.composable.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.settings.navigation.route.AboutRoute

@Composable
fun SettingsScreen(
    navigator: Navigator,
) {
    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Text(text = "Settings")
            Button(onClick = {
                navigator.push(AboutRoute())
            }) {
                Text(text = "About")
            }
        }
    }
}
