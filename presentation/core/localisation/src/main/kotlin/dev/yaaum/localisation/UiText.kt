package dev.yaaum.localisation

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

/**
 * Wrapper over String; Main goal is to use string resources in domain and data (hypothetically)
 * layers.
 *
 * Simple use case: we have general, localised error string in `strings.xml` and some use case
 * wants to pass human-readable error vai string.xml entry.
 */
@Suppress("SpreadOperator")
sealed class UiText {

    /**
     * Wrapper over vanilla String.
     *
     * Use case: String from API
     *
     * @param value
     */
    data class DynamicString(val value: String) : UiText()

    /**
     * Container for string resource. Contains _only_ string id and optional arg.
     *
     * Use case: need to pass some general message from domain to ui using string res
     *
     * @param resId string resource id
     * @param args optional arguments for string formatter
     */
    class StringResource(
        @StringRes val resId: Int,
        vararg val args: Any,
    ) : UiText()

    /**
     * Simple magic. If we call this fun in Composable, [StringResource] will be convert to formatter
     * string using `stringResource`; otherwise, if we have [DynamicString] - it will do nothing
     * cos we already have string
     *
     * @return String
     */
    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> stringResource(resId, *args)
        }
    }

    /**
     * Simple magic. If we call this fun in non composable, [StringResource] will be convert to formatter
     * string using `context.getString`; otherwise, if we have [DynamicString] - it will do nothing
     * cos we already have string
     *
     * @return String
     */
    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(resId, *args)
        }
    }
}
