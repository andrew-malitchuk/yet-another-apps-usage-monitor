package dev.yaaum.presentation.core.ui.error

import dev.yaaum.presentation.core.localisation.R
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

class SwwUiError(
    override val message: UiText? = UiText.StringResource(R.string.error_sww),
    override val throwable: Throwable?,
) : BaseUiError()
