package dev.yaaum.presentation.feature.settings.screen.permission

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.HostViewModel
import dev.yaaum.presentation.feature.settings.screen.permission.content.fetched.PermissionFetchedContent

@Composable
fun PermissionScreen(
    navigator: Navigator,
    hostViewModel: HostViewModel,
    @Suppress("unused")
    permissionViewModel: PermissionViewModel,
) {
    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
    Rebugger(
        trackMap = mapOf(
            "navigator" to navigator,
            "hostViewModel" to hostViewModel,
            "permissionViewModel" to permissionViewModel,
            "isDarkMode" to isDarkMode,
        ),
    )
    YaaumTheme(isDarkMode) {
        PermissionFetchedContent(
            onBackClick = {
                navigator.pop()
            },
        )
    }
}
