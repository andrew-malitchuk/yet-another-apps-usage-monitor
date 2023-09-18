package dev.yaaum.presentation.core.platform.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Just for avoiding boilerplate.
 *
 * Contains safe coroutine launcher and other re-usable stuff suitable for all VMs in this project.
 */
abstract class BaseViewModel : ViewModel() {

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
}
