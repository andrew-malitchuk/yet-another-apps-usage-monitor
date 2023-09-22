package dev.yaaum.presentation.core.platform.activity

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

/**
 * Specify activity behavior and properties.
 *
 * In our case, when we a talking about Compose or single-activity application, i guess, base class
 * for activity is not so necessary, but, it makes code more readable.
 */
@Suppress("unused", "KDocUnresolvedReference")
abstract class BaseActivity : ComponentActivity() {

    private val extras: Bundle? by lazy { intent.extras }
    private val data: Uri? by lazy { intent.data }

    override fun onCreate(savedInstanceState: Bundle?) {
        configureSplash()
        super.onCreate(savedInstanceState)
        observeExtras(extras)
        observeData(data)
        setContent {
            ConfigureUi()
        }
        observeLoading()
        observeEvents()
        observeErrors()
    }

    /**
     * Place for Splash API configuration
     */
    protected open fun configureSplash() = Unit

    /**
     * Place for UI configuration.
     *
     * This method in composable, so you don't need to call
     * ```
     * setContent {
     *    ...
     * }
     * ```
     */
    @Composable
    protected open fun ConfigureUi() = Unit

    /**
     * Can be used for observing loading states (f.e. blocking loader)
     */
    protected open fun observeLoading() = Unit

    /**
     * Place for observing observers ¯\_(ツ)_/¯
     */
    protected open fun observeEvents() = Unit

    /**
     * Can be used for global (application level) errors
     */
    protected open fun observeErrors() = Unit

    /**
     * Place for getting extras which were passed from Intent
     *
     * @param extras income Bundle
     */
    protected open fun observeExtras(extras: Bundle? = null) = Unit

    /**
     * Place for getting data which was passed from Intent
     *
     * @param extras income URI
     */
    protected open fun observeData(data: Uri? = null) = Unit
}
