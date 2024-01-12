package dev.yaaum.presentation.feature.applications.screen.detalization.mvi

import dev.yaaum.domain.applications.GetApplicationUseCase
import dev.yaaum.domain.timeusage.GetWeekStatisticUseCase
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.ui.error.SwwUiError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("Unused", "UnusedPrivateProperty")
class ApplicationDetalizationMvi(
    private val getApplicationUseCase: GetApplicationUseCase,
    private val getWeekStatisticUseCase: GetWeekStatisticUseCase,
) :
    BaseMvi<ApplicationDetalizationMviState, ApplicationDetalizationMviEvent, ApplicationDetalizationMviEffect>() {

    var packageName: String? = null
        set(value) {
            value?.let {
                sendEvent(ApplicationDetalizationMviEvent.GetApplicationDetalizationMviEvent(it))
                sendEvent(ApplicationDetalizationMviEvent.GetApplicationUsageMviEvent(it))
            }
            field = value
        }

    override val state: StateFlow<ApplicationDetalizationMviState>
        get() = reducer.state

    override val effect: SharedFlow<ApplicationDetalizationMviEffect?> = MutableSharedFlow()

    override val reducer =
        ApplicationDetalizationMviReducer(ApplicationDetalizationMviState.initial())

    override fun innerEventProcessing(event: ApplicationDetalizationMviEvent) {
        when (event) {
            is ApplicationDetalizationMviEvent.ApplicationsFetchedMviEvent -> Unit
            is ApplicationDetalizationMviEvent.GetApplicationDetalizationMviEvent ->
                getApplicationDetalization(event.packageName)

            is ApplicationDetalizationMviEvent.ApplicationsDetalizationFetchedMviEvent -> Unit
            is ApplicationDetalizationMviEvent.GetApplicationUsageMviEvent ->
                getAppUsagePerWeek(event.packageName)
        }
    }

    private fun getApplicationDetalization(packageName: String) {
        launch(
            request = {
                getApplicationUseCase(packageName = packageName)
            },
            result = { result ->
                result?.fold({
                    reducer.setState(
                        ApplicationDetalizationMviState.error(
                            // TODO: fix me
                            SwwUiError(
                                UiText.DynamicString(it.message ?: ""),
                                it.throwable,
                            ),
                        ),
                    )
                }, {
                    reducer.setState(
                        ApplicationDetalizationMviState.fetched(
                            content = ApplicationDetalizationMviContent(
                                data = it.toUiModel(),
                                packageName = packageName,
                                weekUsageStatics = state.value.content?.weekUsageStatics,
                            ),
                        ),
                    )
                })
            },
            errorBlock = {
                reducer.setState(
                    ApplicationDetalizationMviState.error(
                        // TODO: fix me
                        SwwUiError(
                            UiText.DynamicString(it.message ?: ""),
                            it,
                        ),
                    ),
                )
            },
        )
    }

    private fun getAppUsagePerWeek(packageName: String) {
        launch(
            request = {
                getWeekStatisticUseCase(
                    packageName,
                )
            },
            result = { result ->
                result?.fold(
                    {
                        reducer.setState(
                            ApplicationDetalizationMviState.error(
                                // TODO: fix me
                                SwwUiError(
                                    UiText.DynamicString(it.message ?: ""),
                                    it.throwable,
                                ),
                            ),
                        )
                    },
                    {
                        // TODO: fix
                        reducer.setState(
                            ApplicationDetalizationMviState.fetched(
                                content = ApplicationDetalizationMviContent(
                                    packageName = reducer.state.value.content?.packageName,
                                    data = reducer.state.value.content?.data,
                                    weekUsageStatics = it.dayAndStatistic.map { it.toUiModel() },
                                ),
                            ),
                        )
                    },
                )
            },
        )
    }
}
