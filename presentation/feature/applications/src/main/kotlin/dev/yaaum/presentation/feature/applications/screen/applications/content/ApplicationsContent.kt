package dev.yaaum.presentation.feature.applications.screen.applications.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.header.TitleHeader
import dev.yaaum.presentation.core.ui.composable.various.AnimatedDivider
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.feature.applications.screen.applications.content.list.ApplicationListItem
import io.github.serpro69.kfaker.Faker

@Suppress("EmptyFunctionBlock")
@Composable
fun ApplicationsContent(
    applicationList: State<List<ApplicationsUiModel>?>,
    onBackClick: (() -> Unit)? = null,
) {
    val lazyScrollState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        TitleHeader(
            icon = ImageVector.vectorResource(R.drawable.icon_caret_left_bold_24),
            title = Faker().quote.fortuneCookie(),
            onClick = onBackClick,
        )
        AnimatedDivider(
            state = lazyScrollState,
            modifier = Modifier.fillMaxWidth(),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
                .background(dev.yaaum.presentation.core.ui.theme.common.YaaumTheme.colors.background)
                .padding(horizontal = dev.yaaum.presentation.core.ui.theme.common.YaaumTheme.spacing.medium),
            state = lazyScrollState,
            verticalArrangement = Arrangement
                .spacedBy(dev.yaaum.presentation.core.ui.theme.common.YaaumTheme.spacing.small),
        ) {
            applicationList.value?.let {
                items(
                    count = it.size,
                ) { index ->
                    ApplicationListItem(it[index])
                }
            }
        }
        AnimatedDivider(state = lazyScrollState, isInverted = true)
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
