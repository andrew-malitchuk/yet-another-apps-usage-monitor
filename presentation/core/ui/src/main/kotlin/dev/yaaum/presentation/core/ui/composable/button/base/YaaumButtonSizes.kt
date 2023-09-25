package dev.yaaum.presentation.core.ui.composable.button.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@Immutable
interface YaaumButtonSizes {
    val iconSize: Dp
    val borderSize: Dp
    val contentPadding: PaddingValues
    val spacing: Dp
    val minWidth: Dp
    val minHeight: Dp
}
