package dev.yaaum.presentation.core.ui.composable.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

// https://semicolonspace.com/jetpack-compose-basictextfield/
@Composable
fun Foo(
    text: String? = null,
    onTextChanged: ((String) -> Unit)? = null,
) {
    var textState by remember { mutableStateOf(text) }
    BasicTextField(
        value = textState ?: "",
        onValueChange = {
            onTextChanged?.invoke(it)
            textState = it
        },
        textStyle = YaaumTheme.typography.button,
        decorationBox = { innerTextField ->
            @Suppress("MagicNumber")
            Row(
                modifier = Modifier
                    .padding(horizontal = 64.dp) // margin left and right
                    .fillMaxWidth()
                    .background(color = Color(0xFFD2F3F2), shape = RoundedCornerShape(size = 16.dp))
                    .border(
                        width = 2.dp,
                        color = Color(0xFFAAE9E6),
                        shape = RoundedCornerShape(size = 16.dp),
                    )
                    .padding(all = 16.dp), // inner padding
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Favorite icon",
                    tint = Color.DarkGray,
                )
                Spacer(modifier = Modifier.width(width = 8.dp))
                innerTextField()
            }
        },
    )
}
