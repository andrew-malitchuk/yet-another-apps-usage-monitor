package dev.yaaum.presentation.feature.main.screen.composable.applications

import androidx.compose.runtime.Composable
import dev.yaaum.presentation.core.models.isDarkMode
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.screen.composable.HostViewModel
import dev.yaaum.presentation.feature.main.screen.composable.applications.content.ApplicationsContent
import org.koin.androidx.compose.inject
import org.koin.java.KoinJavaComponent

@Composable
fun ApplicationsScreen(
//    navigator: Navigator,
//    hostViewModel: HostViewModel,
) {
    val hostViewModel: HostViewModel by KoinJavaComponent.inject(HostViewModel::class.java)

    val isDarkMode = hostViewModel.currentThemeUiModel.value?.isDarkMode() ?: false
//    val isDarkMode = true
    YaaumTheme(useDarkTheme = isDarkMode) {
        ApplicationsContent()
    }
}

// @Preview(showBackground = true)
// @Composable
// fun Preview_ApplicationsScreen_Dark() {
//    YaaumTheme(useDarkTheme = true) {
//        ApplicationsScreen()
//    }
// }
//
// @Preview(showBackground = true)
// @Composable
// fun Preview_ApplicationsScreen_Light() {
//    YaaumTheme(useDarkTheme = false) {
//        ApplicationsScreen()
//    }
// }
