package dev.yaaum.onboarding.navigation

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import dev.yaaum.navigation.RouteGraph.ONBOARDING_ROUTE
import dev.yaaum.onboarding.screen.onboarding.OnboardingScreen

@Destination(
    start = true,
    route = ONBOARDING_ROUTE,
)
@Composable
fun OnboardingRoute() {
    OnboardingScreen()
}
