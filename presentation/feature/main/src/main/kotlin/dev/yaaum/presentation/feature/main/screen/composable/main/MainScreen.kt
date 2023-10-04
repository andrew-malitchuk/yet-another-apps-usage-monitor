package dev.yaaum.presentation.feature.main.screen.composable.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.theapache64.rebugger.Rebugger
import dev.yaaum.presentation.core.ui.etc.NoRippleTheme
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.main.navigation.tab.AddTab
import dev.yaaum.presentation.feature.main.navigation.tab.ApplicationListTab
import dev.yaaum.presentation.feature.main.navigation.tab.HeathTab
import dev.yaaum.presentation.feature.main.navigation.tab.SettingsTab
import dev.yaaum.presentation.feature.main.navigation.tab.StatisticTab
import dev.yaaum.presentation.feature.main.screen.composable.ui.tab.CenterButton
import dev.yaaum.presentation.feature.main.screen.composable.ui.tab.TabNavigationItem

@Composable
fun MainScreen() {
    Rebugger(
        trackMap = mapOf(),
    )
    YaaumTheme {
        TabNavigator(
            HeathTab,
        ) {
            Box(
                modifier =
                Modifier.fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                ) {
                    CurrentTab()
                }
                CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                    BottomNavigation(
                        backgroundColor = YaaumTheme.colors.surface,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(YaaumTheme.spacing.small)
                            .clip(YaaumTheme.shapes.medium)
                            .align(Alignment.BottomCenter),
                    ) {
                        TabNavigationItem(HeathTab)
                        TabNavigationItem(ApplicationListTab)
                        CenterButton(AddTab)
                        TabNavigationItem(StatisticTab)
                        TabNavigationItem(SettingsTab)
                    }
                }
            }
        }
    }
}
