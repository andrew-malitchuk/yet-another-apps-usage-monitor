package dev.yaaum.presentation.feature.main.navigation.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

val tabs = listOf(
    HeathTab,
    ApplicationListTab,
    AddTab,
    StatisticTab,
    SettingsTab,
)

sealed class MainTabs : Tab

data object HeathTab : MainTabs() {
    override val options: TabOptions
        @Composable
        get() {
//                val title = stringResource(R.string.home_tab)
            val title = "health"
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = "health",
            )
        }
    }
}

data object ApplicationListTab : MainTabs() {
    override val options: TabOptions
        @Composable
        get() {
//                val title = stringResource(R.string.home_tab)
            val title = "applications"
            val icon = rememberVectorPainter(Icons.Default.List)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = "applications",
            )
        }
    }
}

data object AddTab : MainTabs() {
    override val options: TabOptions
        @Composable
        get() {
//                val title = stringResource(R.string.home_tab)
            val title = "add"
            val icon = rememberVectorPainter(Icons.Default.Add)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Magenta),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = "add",
            )
        }
    }
}

data object StatisticTab : MainTabs() {
    override val options: TabOptions
        @Composable
        get() {
//                val title = stringResource(R.string.home_tab)
            val title = "statistic"
            val icon = rememberVectorPainter(Icons.Default.Create)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = "statistic",
            )
        }
    }
}

data object SettingsTab : MainTabs() {
    override val options: TabOptions
        @Composable
        get() {
//                val title = stringResource(R.string.home_tab)
            val title = "settings"
            val icon = rememberVectorPainter(Icons.Default.Settings)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = "settings",
            )
        }
    }
}
