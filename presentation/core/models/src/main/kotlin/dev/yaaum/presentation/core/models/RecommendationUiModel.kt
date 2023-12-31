package dev.yaaum.presentation.core.models

import dev.yaaum.presentation.core.models.base.BaseUiModel

/**
 * Represent recommendation a.k.a. "banners"
 */
data class RecommendationUiModel(
    val title: String,
    val description: String,
    val deeplink: String,
) : BaseUiModel
