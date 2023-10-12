package dev.yaaum.presentation.feature.applications.screen.composable.applications.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

@Suppress("EmptyFunctionBlock")
@Composable
fun ApplicationsContent(
    applicationList: State<List<ApplicationsUiModel>?>,
) {
    LazyColumn() {
        applicationList?.value?.let {
            items(
                count = it.size,
            ) { index ->
                val item = it[index]
                Row() {
                    val icon = item.packageName?.let { it1 ->
                        LocalContext.current.packageManager.getApplicationIcon(
                            it1,
                        )
                    }
                    Image(
                        painter = rememberDrawablePainter(icon),
                        contentDescription = null,
                    )
                    Text(text = item.packageName ?: "")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsContent_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationsContent(
            applicationList = remember { mutableStateOf(emptyList()) },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsContent_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationsContent(
            applicationList = remember { mutableStateOf(emptyList()) },
        )
    }
}
