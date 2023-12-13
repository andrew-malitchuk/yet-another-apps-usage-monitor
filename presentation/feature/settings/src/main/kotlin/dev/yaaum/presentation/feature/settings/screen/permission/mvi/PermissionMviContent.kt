package dev.yaaum.presentation.feature.settings.screen.permission.mvi

import dev.yaaum.presentation.core.platform.mvi.state.content.MviContent

data class PermissionMviContent(
    val data: PermissionConfigure?,
) : MviContent
