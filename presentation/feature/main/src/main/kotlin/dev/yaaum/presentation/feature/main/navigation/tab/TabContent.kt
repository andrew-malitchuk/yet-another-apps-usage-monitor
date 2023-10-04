package dev.yaaum.presentation.feature.main.navigation.tab

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.transitions.SlideTransition
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Tab.TabContent() {
    val tabTitle = options.title
    LifecycleEffect(
        onStarted = { Log.d("Navigator", "Start tab $tabTitle") },
        onDisposed = { Log.d("Navigator", "Dispose tab $tabTitle") },
    )

    Navigator(tabs) { navigator ->
        SlideTransition(navigator) { screen ->
            Column {
                InnerTabNavigation()
                screen.Content()
            }
        }
    }
}

@Composable
private fun InnerTabNavigation() {
    Row(
        modifier = Modifier.padding(YaaumTheme.spacing.medium),
    ) {
        TabNavigationButton(HeathTab)
        TabNavigationButton(HeathTab)
        TabNavigationButton(HeathTab)
    }
}

@Composable
private fun RowScope.TabNavigationButton(
    tab: Tab,
) {
    val tabNavigator = LocalTabNavigator.current

    Button(
        enabled = tabNavigator.current.key != tab.key,
        onClick = { tabNavigator.current = tab },
        modifier = Modifier.weight(1f),
    ) {
        Text(text = tab.options.title)
    }
}
