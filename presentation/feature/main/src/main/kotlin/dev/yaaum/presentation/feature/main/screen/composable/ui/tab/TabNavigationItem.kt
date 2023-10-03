package dev.yaaum.presentation.feature.main.screen.composable.ui.tab

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) },
    )
}

@Composable
fun Foo(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    FloatingActionButton(
//        modifier = Modifier
//            .padding(YaaumTheme.spacing.extraSmall),
        backgroundColor = YaaumTheme.colors.primary,
        contentColor = if (tabNavigator.current.key == tab.key) {
            YaaumTheme.colors.onPrimary
        } else {
            YaaumTheme.colors.background
        },
        onClick = {
            tabNavigator.current = tab
        },
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
    ) {
        Icon(painter = tab.options.icon!!, contentDescription = tab.options.title)
    }
}
