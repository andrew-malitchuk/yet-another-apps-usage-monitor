package dev.yaaum.presentation.core.ui.composable.various.pulltorefresh

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.MutableStateFlow

class YaaumPullToRefreshLayoutState(
    val onTimeUpdated: (Long) -> String,
) {

    private val _lastRefreshTime: MutableStateFlow<Long> = MutableStateFlow(System.currentTimeMillis())

    var refreshIndicatorState = mutableStateOf(YaaumRefreshIndicatorState.Default)
        private set

    var lastRefreshText = mutableStateOf("")
        private set

    fun updateRefreshState(refreshState: YaaumRefreshIndicatorState) {
        val now = System.currentTimeMillis()
        val timeElapsed = now - _lastRefreshTime.value
        lastRefreshText.value = onTimeUpdated(timeElapsed)
        refreshIndicatorState.value = refreshState
    }

    fun refresh() {
        _lastRefreshTime.value = System.currentTimeMillis()
        updateRefreshState(YaaumRefreshIndicatorState.Refreshing)
    }
}

@Composable
fun rememberPullToRefreshState(
    onTimeUpdated: (Long) -> String,
): YaaumPullToRefreshLayoutState =
    remember {
        YaaumPullToRefreshLayoutState(onTimeUpdated)
    }
