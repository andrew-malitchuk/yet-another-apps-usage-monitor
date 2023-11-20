package dev.yaaum.presentation.core.platform.vm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import dev.yaaum.common.core.error.SwwError
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel
import dev.yaaum.presentation.core.analytics.logger.AnalyticsLogger
import dev.yaaum.presentation.core.platform.mvi.Contract
import dev.yaaum.presentation.core.platform.mvi.Effect
import dev.yaaum.presentation.core.platform.mvi.Error
import dev.yaaum.presentation.core.platform.mvi.Intent
import dev.yaaum.presentation.core.platform.mvi.Loading
import dev.yaaum.presentation.core.platform.mvi.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent
import kotlin.coroutines.CoroutineContext

abstract class UnidirectionalViewModel<STATE : State, INTENT : Intent, EFFECT : Effect> :
    ViewModel(),
    Contract<STATE, INTENT, EFFECT> {

    abstract override val state: StateFlow<STATE>

    abstract override val effect: SharedFlow<EFFECT>

    abstract override fun event(event: INTENT)

    @Suppress("MemberVisibilityCanBePrivate")
    val analyticsLogger: AnalyticsLogger by KoinJavaComponent.inject(AnalyticsLogger::class.java)

    /**
     * Error-safe coroutine launcher.
     *
     * @param context CoroutineContext for coroutine executing
     * @param scope CoroutineScope to run in
     * @param debounce defines time limits between each executing
     * @param request block to execute
     * @param loading defines coroutine loading status
     * @param result returns result of execution
     * @param errorBlock block for unexpected exceptions
     *
     * @return Coroutine Job
     */
    @Suppress("TooGenericExceptionCaught")
    fun <T> call(
        context: CoroutineContext = Dispatchers.IO,
        scope: CoroutineScope = viewModelScope,
        debounce: Long? = null,
        request: suspend CoroutineScope.() -> T?,
        loading: ((Boolean) -> Unit)? = null,
        result: ((T?) -> Unit)? = null,
        errorBlock: ((Throwable) -> Unit)? = null,
    ): Job {
        return scope.launch {
            try {
                debounce?.let {
                    delay(it)
                }
                loading?.invoke(true)
                state.setValue(Loading())
                withContext(context) { request() }.apply {
                    this.let { result?.invoke(it) }
                }
            } catch (e: Throwable) {
                errorBlock?.invoke(e)
                state.setValue(Error(SwwError(throwable = e)))
                loading?.invoke(false)
            } finally {
                loading?.invoke(false)
            }
        }
    }

    /**
     * To avoid boilerplate (private MutableStateFlow & public StateFlow), this extension has been
     * created
     */
    protected fun <T> StateFlow<T>.setValue(value: T) {
        (this as? MutableStateFlow)?.update {
            value
        }
    }

    /**
     * Log analytics event in DSL way
     *
     * @param staffToTrack some analytic event
     */
    fun logEvent(staffToTrack: () -> BaseAnalyticModel) {
        analyticsLogger.logEvent(staffToTrack)
    }

    abstract fun load()

    open fun reset() = Unit

    open fun reload() {
        load()
    }
}

@Composable
inline fun <reified STATE : State, INTENT : Intent, EFFECT : Effect> use(
    viewModel: UnidirectionalViewModel<STATE, INTENT, EFFECT>,
): StateDispatchEffect<STATE, INTENT, EFFECT> {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val dispatch: (INTENT) -> Unit = { event ->
        viewModel.event(event)
    }

    return StateDispatchEffect(
        state = state,
        effectFlow = viewModel.effect,
        dispatch = dispatch,
    )
}

data class StateDispatchEffect<STATE, EVENT, EFFECT>(
    val state: STATE,
    val dispatch: (EVENT) -> Unit,
    val effectFlow: SharedFlow<EFFECT>,
)
