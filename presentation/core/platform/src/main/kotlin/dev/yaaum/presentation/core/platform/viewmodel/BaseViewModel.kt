package dev.yaaum.presentation.core.platform.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.yaaum.presentation.core.analytics.core.model.base.BaseAnalyticModel
import dev.yaaum.presentation.core.analytics.logger.AnalyticsLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject
import kotlin.coroutines.CoroutineContext

/**
 * Just for avoiding boilerplate.
 *
 * Contains safe coroutine launcher and other re-usable stuff suitable for all VMs in this project.
 */
@Suppress("unused")
abstract class BaseViewModel : ViewModel() {

    val analyticsLogger: AnalyticsLogger by inject(AnalyticsLogger::class.java)

    /**
     * Container for hypothetical errors which might happens in [launch]
     */
    val errorChannel = Channel<Throwable?>(Channel.BUFFERED)

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

    var isDataLoaded: Boolean = false

    open fun load() = Unit

    open fun reset() = Unit

    fun reload() {
        isDataLoaded = false
        load()
    }
}
