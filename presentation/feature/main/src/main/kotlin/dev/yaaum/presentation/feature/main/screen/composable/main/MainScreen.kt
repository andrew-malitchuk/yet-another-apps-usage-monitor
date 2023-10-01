package dev.yaaum.presentation.feature.main.screen.composable.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.main.navigation.tab.AddTab
import dev.yaaum.presentation.feature.main.navigation.tab.ApplicationListTab
import dev.yaaum.presentation.feature.main.navigation.tab.HeathTab
import dev.yaaum.presentation.feature.main.navigation.tab.SettingsTab
import dev.yaaum.presentation.feature.main.navigation.tab.StatisticTab
import dev.yaaum.presentation.feature.main.screen.composable.ui.tab.TabNavigationItem

@Composable
fun MainScreen() {
    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme {
        TabNavigator(
            HeathTab,
        ) { tabNavigator ->
            Scaffold(
                content = {
                    Column(
                        modifier = Modifier
                            .padding(it),
                    ) {
                        CurrentTab()
                    }
                },
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(HeathTab)
                        TabNavigationItem(ApplicationListTab)
                        TabNavigationItem(AddTab)
                        TabNavigationItem(StatisticTab)
                        TabNavigationItem(SettingsTab)
                    }
                },
            )
        }
    }
}
