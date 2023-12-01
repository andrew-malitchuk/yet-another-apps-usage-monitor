package dev.yaaum.presentation.core.ui.composable.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YaaumBottomSheetDialog(
    onDismiss: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )

    ModalBottomSheet(
        onDismissRequest = { onDismiss?.invoke() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        shape = RoundedCornerShape(
            topStart = YaaumTheme.corners.medium,
            topEnd = YaaumTheme.corners.medium,
        ),
        containerColor = YaaumTheme.colors.background,
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumBottomSheetDialog_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumBottomSheetDialog(
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(YaaumTheme.spacing.extraLarge)
                        .background(YaaumTheme.colors.primary),
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumBottomSheetDialog_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumBottomSheetDialog(
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(YaaumTheme.spacing.extraLarge)
                        .background(YaaumTheme.colors.primary),
                )
            },
        )
    }
}
