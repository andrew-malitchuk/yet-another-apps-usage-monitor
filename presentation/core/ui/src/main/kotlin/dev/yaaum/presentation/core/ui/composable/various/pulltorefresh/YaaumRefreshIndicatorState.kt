package dev.yaaum.presentation.core.ui.composable.various.pulltorefresh

/*enum class YaaumRefreshIndicatorState(@StringRes val messageRes: Int) {
    Default( R.string.pull_to_refresh_complete_label),
    PullingDown(R.string.pull_to_refresh_pull_label),
    ReachedThreshold(R.string.pull_to_refresh_release_label),
    Refreshing(R.string.pull_to_refresh_refreshing_label)
}*/
enum class YaaumRefreshIndicatorState(val message: String) {
    Default("default"),
    PullingDown("pulling-down"),
    ReachedThreshold("reached-threshold"),
    Refreshing("refreshing"),
}
