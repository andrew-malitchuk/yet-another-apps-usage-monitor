package dev.yaaum.presentation.feature.applications.screen.applications.mvi

import dev.yaaum.domain.applications.AddAppToChosenUseCase
import dev.yaaum.domain.applications.FilterAllApplicationWithChosenUseCase
import dev.yaaum.domain.applications.FilterAllAppsUseCase
import dev.yaaum.domain.applications.GetUserAppsUseCase
import dev.yaaum.domain.applications.RemoveAppFromChosenUseCase
import dev.yaaum.domain.core.model.SortOrder
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.ui.error.SwwUiError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

@Suppress("Unused", "UnusedPrivateProperty")
class ApplicationsMvi(
    private val getAllAppsUseCase: GetUserAppsUseCase,
    private val filterAllAppsUseCase: FilterAllAppsUseCase,
    private val addAppToChosenUseCase: AddAppToChosenUseCase,
    private val removeAppFromChosenUseCase: RemoveAppFromChosenUseCase,
    private val filterAllApplicationWithChosenUseCase: FilterAllApplicationWithChosenUseCase,
) : BaseMvi<ApplicationsMviState, ApplicationsMviEvent, ApplicationsMviEffect>() {

    override val state: StateFlow<ApplicationsMviState>
        get() = reducer.state

    override val effect: SharedFlow<ApplicationsMviEffect?> = MutableSharedFlow()

    override val reducer = ApplicationsMviReducer(ApplicationsMviState.initial())

    override fun innerEventProcessing(event: ApplicationsMviEvent) {
        when (event) {
            is ApplicationsMviEvent.ApplicationsFetchedMviEvent -> Unit
            ApplicationsMviEvent.GetApplicationsMviEvent -> filter()
        }
    }

    private fun filter(query: String? = null, order: SortOrder? = null) {
        launch(
            request = {
                filterAllApplicationWithChosenUseCase(
                    query,
                    order ?: SortOrder.ASC,
                )
            },
            result = { result ->
                result?.fold(
                    {
                        reducer.setState(
                            ApplicationsMviState.error(
                                // TODO: fix me
                                SwwUiError(
                                    UiText.DynamicString(it.message ?: ""),
                                    it.throwable,
                                ),
                            ),
                        )
                    },
                    { filter ->
                        reducer.setState(
                            ApplicationsMviState.fetched(
                                data = filter.map { it.toUiModel() },
                            ),
                        )
                    },
                )
            },
        )
    }

    init {
        sendEvent(ApplicationsMviEvent.GetApplicationsMviEvent)
    }
}
