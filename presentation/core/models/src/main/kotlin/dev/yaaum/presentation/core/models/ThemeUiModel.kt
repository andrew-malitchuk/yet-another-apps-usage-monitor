package dev.yaaum.presentation.core.models

import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Represent theme, which was selected by user
 */
enum class ThemeUiModel(val theme: String) : BaseUiModel {
    DARK("dark"),
    LIGHT("light"),

    /**
     * According to system settings
     */
    AUTO("auto"),

    /**
     * Material U color palette will be chosen
     */
    DYNAMIC("dynamic"),
}

fun ThemeUiModel.isDarkMode(): Boolean {
    return this.theme == ThemeUiModel.DARK.theme
}
