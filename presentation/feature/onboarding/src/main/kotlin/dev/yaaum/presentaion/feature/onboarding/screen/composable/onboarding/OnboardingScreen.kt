package dev.yaaum.presentaion.feature.onboarding.screen.composable.onboarding

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentaion.feature.onboarding.screen.OnboardingViewModel
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.navigation.RouteGraph
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButton
import dev.yaaum.presentation.core.ui.composable.button.circle.base.YaaumCircleButton
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
            val context = LocalContext.current
            YaaumButton(
                text = "foo",
                onClick = {
                    Toast.makeText(
                        context,
                        "foobar",
                        Toast.LENGTH_SHORT,
                    ).show()
                },
                icon = Icons.Default.Person,
            )
            YaaumCircleButton(
                onClick = {
                },
                icon = Icons.Default.Add,
            )
        }
    }
}
