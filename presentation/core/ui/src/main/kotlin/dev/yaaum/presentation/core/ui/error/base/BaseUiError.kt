package dev.yaaum.presentation.core.ui.error.base

import dev.yaaum.presentation.core.localisation.UiText

abstract class BaseUiError {
    abstract val message: UiText?
    abstract val throwable: Throwable?
}
