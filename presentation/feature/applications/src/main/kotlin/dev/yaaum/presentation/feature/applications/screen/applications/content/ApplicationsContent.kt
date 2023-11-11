package dev.yaaum.presentation.feature.applications.screen.applications.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.swipe.YaaumDoubleSideButton
import dev.yaaum.presentation.core.ui.composable.header.TitleHeader
import dev.yaaum.presentation.core.ui.composable.input.YaaumBasicTextField
import dev.yaaum.presentation.core.ui.composable.various.AnimatedDivider
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.applications.screen.applications.content.list.ApplicationListItem
import io.github.serpro69.kfaker.Faker

@Suppress("EmptyFunctionBlock")
@Composable
fun ApplicationsContent(
    applicationList: State<List<ApplicationsUiModel>?>,
    onBackClick: (() -> Unit)? = null,
    onTextChange: ((String) -> Unit)? = null,
    onSideChange: ((Boolean) -> Unit)? = null,
    onApplicationClick: ((ApplicationsUiModel, Boolean) -> Unit)? = null,
) {
    val lazyScrollState = rememberLazyListState()
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(YaaumTheme.colors.background)
            .padding(vertical = YaaumTheme.spacing.medium),
    ) {
        TitleHeader(
            modifier = Modifier.padding(vertical = YaaumTheme.spacing.small),
            icon = R.drawable.icon_caret_left_bold_24,
            title = Faker().quote.fortuneCookie(),
            onClick = onBackClick,
        )
        Row(
            modifier = Modifier
                .background(YaaumTheme.colors.background)
                .padding(
                    horizontal = YaaumTheme.spacing.medium,
                    vertical = YaaumTheme.spacing.small,
                ),
        ) {
            YaaumBasicTextField(
                modifier = Modifier
                    .weight(1f),
                text = text,
                onTextChanged = {
                    text = it
                    onTextChange?.invoke(it)
                },
            )
            Spacer(modifier = Modifier.width(YaaumTheme.spacing.extraSmall))
            YaaumDoubleSideButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                sideA = R.drawable.icon_sort_ascending_bold_24,
                sideB = R.drawable.icon_sort_descending_bold_24,
                onSideChange = onSideChange,
            )
        }
        AnimatedDivider(
            state = lazyScrollState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
                .background(YaaumTheme.colors.background)
                .padding(horizontal = YaaumTheme.spacing.medium),
            state = lazyScrollState,
            verticalArrangement = Arrangement
                .spacedBy(YaaumTheme.spacing.small),
        ) {
            applicationList.value?.let {
                items(
                    count = it.size,
                ) { index ->
                    ApplicationListItem(
                        applicationsUiModel = it[index],
                        onApplicationClick = onApplicationClick,
                    )
                }
            }
        }
        AnimatedDivider(
            state = lazyScrollState,
            isInverted = true,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
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
