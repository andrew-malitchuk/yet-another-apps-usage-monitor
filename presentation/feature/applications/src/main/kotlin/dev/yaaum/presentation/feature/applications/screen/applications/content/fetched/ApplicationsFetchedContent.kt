package dev.yaaum.presentation.feature.applications.screen.applications.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.domain.core.model.SortOrder
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.swipe.YaaumDoubleSideButton
import dev.yaaum.presentation.core.ui.composable.header.TitleHeader
import dev.yaaum.presentation.core.ui.composable.input.YaaumBasicTextField
import dev.yaaum.presentation.core.ui.composable.various.AnimatedDivider
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.applications.screen.applications.content.empty.ApplicationsEmptyContent
import dev.yaaum.presentation.feature.applications.screen.applications.content.loading.ApplicationsLoadingContent
import dev.yaaum.presentation.feature.applications.screen.applications.item.fetched.ApplicationFetchedListItem
import dev.yaaum.presentation.feature.applications.screen.applications.mvi.ApplicationsMviContent
import dev.yaaum.presentation.feature.applications.screen.applications.mvi.ApplicationsMviState
import io.github.serpro69.kfaker.Faker

@Suppress("EmptyFunctionBlock", "LongMethod")
@Composable
fun ApplicationsFetchedContent(
    state: ApplicationsMviState,
    onBackClick: (() -> Unit)? = null,
    onTextChange: ((String) -> Unit)? = null,
    onSideChange: ((Boolean) -> Unit)? = null,
    onApplicationClick: ((ApplicationsUiModel, Boolean) -> Unit)? = null,
) {
    val lazyScrollState = rememberLazyListState()
    var text by remember { mutableStateOf(state.query) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(YaaumTheme.colors.background)
            .padding(vertical = YaaumTheme.spacing.medium),
    ) {
        TitleHeader(
            modifier = Modifier.padding(vertical = YaaumTheme.spacing.small),
            title = UiText
                .StringResource(dev.yaaum.presentation.core.localisation.R.string.applications_title)
                .asString(LocalContext.current),
            onBackClick = onBackClick,
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
                onCleanTextClick = {
                    text = ""
                    onTextChange?.invoke("")
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

        Box(
            modifier = Modifier
                .weight(1.0f),
        ) {
            when {
                (state.content?.data?.isEmpty() == true) ->
                    Column {
                        AnimatedDivider(
                            state = lazyScrollState,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                        )
                        ApplicationsEmptyContent()
                    }

                (state.content?.data == null) ->
                    Column {
                        AnimatedDivider(
                            state = lazyScrollState,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                        )
                        ApplicationsLoadingContent()
                    }

                else ->
                    Column {
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
                            state.content.data.let { list ->
                                items(
                                    count = list.size,
                                ) { index ->
                                    ApplicationFetchedListItem(
                                        applicationsUiModel = list[index],
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsFetchedContent_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        ApplicationsFetchedContent(
            state = ApplicationsMviState.fetched(
                content = ApplicationsMviContent(
                    data = listOf(
                        @Suppress("MagicNumber")
                        ApplicationsUiModel(
                            123,
                            faker.quote.fortuneCookie(),
                            faker.quote.fortuneCookie(),
                        ),
                    ),
                ),
                query = faker.quote.fortuneCookie(),
                sort = SortOrder.ASC,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationsFetchedContent_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        ApplicationsFetchedContent(
            state = ApplicationsMviState.fetched(
                content = ApplicationsMviContent(
                    data = listOf(
                        @Suppress("MagicNumber")
                        ApplicationsUiModel(
                            123,
                            faker.quote.fortuneCookie(),
                            faker.quote.fortuneCookie(),
                        ),
                    ),
                ),
                query = faker.quote.fortuneCookie(),
                sort = SortOrder.ASC,
            ),
        )
    }
}
