package dev.yaaum.presentation.core.platform.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel
import dev.yaaum.presentation.core.analytics.logger.AnalyticsLogger
import dev.yaaum.presentation.core.platform.mvi.effect.MviEffect
import dev.yaaum.presentation.core.platform.mvi.event.MviEvent
import dev.yaaum.presentation.core.platform.mvi.state.MviState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent
import kotlin.coroutines.CoroutineContext

// TODO: doc
abstract class BaseMvi<STATE : MviState, in EVENT : MviEvent, EFFECT : MviEffect> : ViewModel() {

    abstract val state: Flow<STATE>

    abstract val effect: SharedFlow<EFFECT?>

    abstract val reducer: MviReducer<STATE, @UnsafeVariance EVENT>

    // TODO: doc
    val analyticsLogger: AnalyticsLogger by KoinJavaComponent.inject(AnalyticsLogger::class.java)

    open fun sendEvent(event: EVENT) {
        innerEventProcessing(event)
        reducer.sendEvent(event)
    }

    open fun sendEffect(effect: EFFECT) {
        innerEffectProcessing(effect)
        viewModelScope.launch {
            this@BaseMvi.effect.lazyEmit(effect)
        }
    }

    protected open fun innerEventProcessing(event: EVENT) = Unit

    protected open fun innerEffectProcessing(effect: EFFECT) = Unit

    /**
     * To avoid boilerplate (private MutableStateFlow & public StateFlow), this extension has been
     * created
     */
    protected fun <T> StateFlow<T>.setValue(value: T) {
        (this as? MutableStateFlow)?.update {
            value
        }
    }

    protected suspend fun <T> SharedFlow<T>.lazyEmit(value: T) {
        (this as? MutableSharedFlow)?.emit(value)
    }

    /**
     * Log analytics event in DSL way
     *
     * @param staffToTrack some analytic event
     */
    fun logEvent(staffToTrack: () -> BaseAnalyticModel) {
        analyticsLogger.logEvent(staffToTrack)
    }

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
    fun <T> launch(
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
                withContext(context) { request() }.apply {
                    this.let { result?.invoke(it) }
                }
            } catch (e: Throwable) {
                errorBlock?.invoke(e)
                loading?.invoke(false)
            } finally {
                loading?.invoke(false)
            }
        }
    }
}
