package dev.yaaum.presentation.feature.applications.screen.applications.mvi

import dev.yaaum.domain.applications.AddAppToChosenUseCase
import dev.yaaum.domain.applications.FilterAllApplicationWithChosenUseCase
import dev.yaaum.domain.applications.FilterAllAppsUseCase
import dev.yaaum.domain.applications.GetUserAppsUseCase
import dev.yaaum.domain.applications.RemoveAppFromChosenUseCase
import dev.yaaum.domain.core.model.SortOrder
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.models.toDomainModel
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.mvi.BaseMvi
import dev.yaaum.presentation.core.ui.error.SwwUiError
import kotlinx.coroutines.Job
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

    private var searchJob: Job? = null

    override fun innerEventProcessing(event: ApplicationsMviEvent) {
        when (event) {
            is ApplicationsMviEvent.ApplicationsFetchedMviEvent -> Unit
            ApplicationsMviEvent.GetApplicationsMviEvent -> filter(event)
            is ApplicationsMviEvent.OnSortChangedMviEvent -> filter(
                event = event,
            )

            is ApplicationsMviEvent.OnQueryChangedMviEvent -> filter(
                event = event,
            )

            is ApplicationsMviEvent.OnApplicationStatusChangedEvent ->
                changeApplicationStatus(
                    application = event.application,
                    isChosen = event.isChosen,
                )

            is ApplicationsMviEvent.ApplicationsUpdatedFetchedMviEvent -> Unit
        }
    }

    private fun filter(event: ApplicationsMviEvent) {
        launch(
            request = {
                when (event) {
                    is ApplicationsMviEvent.OnQueryChangedMviEvent,
                    is ApplicationsMviEvent.OnSortChangedMviEvent,
                    ->
                        filterAllApplicationWithChosenUseCase(
                            query = reducer.state.value.query,
                            sortOrder = reducer.state.value.sort ?: SortOrder.ASC,
                        )

                    else ->
                        filterAllApplicationWithChosenUseCase(
                            query = "",
                            sortOrder = SortOrder.ASC,
                        )
                }
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
                                content = ApplicationsMviContent(
                                    data = filter.map { it.toUiModel() },
                                ),
                                query = reducer.state.value.query,
                                sort = reducer.state.value.sort ?: SortOrder.ASC,
                            ),
                        )
                    },
                )
            },
        )
    }

    fun onTextChange(query: String) {
        searchJob?.cancel()
        searchJob = launch(
            debounce = 1_000L,
            request = {
                sendEvent(
                    ApplicationsMviEvent.OnQueryChangedMviEvent(
                        query = query,
                    ),
                )
            },
        )
    }

    private fun changeApplicationStatus(application: ApplicationsUiModel, isChosen: Boolean) {
        launch(
            request = {
                arrow.core.raise.recover({
                    if (isChosen) {
                        addAppToChosenUseCase(application.toDomainModel())
                    } else {
                        removeAppFromChosenUseCase(application.toDomainModel())
                    }
                    // TODO: fix
                    val foo = application.copy(isChosen = isChosen)
                    sendEvent(ApplicationsMviEvent.ApplicationsUpdatedFetchedMviEvent(foo))
                }, {
                    // TODO: fix
                    it.toString()
                })
            },
        )
    }
}
