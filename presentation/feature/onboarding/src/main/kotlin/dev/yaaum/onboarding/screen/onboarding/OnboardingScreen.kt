package dev.yaaum.onboarding.screen.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.theapache64.rebugger.Rebugger
import dev.yaaum.ui.theme.YaaumTheme

@Composable
fun OnboardingScreen() {
    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme() {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = "Onboarding",
            )
        }
    }
}
