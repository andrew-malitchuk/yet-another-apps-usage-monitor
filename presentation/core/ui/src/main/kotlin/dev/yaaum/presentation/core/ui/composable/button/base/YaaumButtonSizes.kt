package dev.yaaum.presentation.core.ui.composable.button.base

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

/**
 * Specify buttons elements size
 *
 * Contains sizes of:
 * - icon;
 * - border;
 * - padding between content;
 * - spacing between text & icon;
 * - min width;
 * - min height.
 */
@Immutable
interface YaaumButtonSizes {
    @get:Composable
    val iconSize: Dp

    @get:Composable
    val borderSize: Dp

    @get:Composable
    val contentPadding: PaddingValues

    @get:Composable
    val spacing: Dp

    @get:Composable
    val minWidth: Dp

    @get:Composable
    val minHeight: Dp
}
