package dev.yaaum.presentation.core.ui.error

import dev.yaaum.presentation.core.localisation.R
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.ui.error.base.BaseUiError

class NoDataUiError(
    override val message: UiText? = UiText.StringResource(R.string.error_no_data),
    override val throwable: Throwable?,
) : BaseUiError()
