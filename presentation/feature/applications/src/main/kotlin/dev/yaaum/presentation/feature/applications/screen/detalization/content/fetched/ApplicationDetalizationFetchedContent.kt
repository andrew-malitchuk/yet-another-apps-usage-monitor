package dev.yaaum.presentation.feature.applications.screen.detalization.content.fetched

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.ui.composable.card.ApplicationDetalizationCard
import dev.yaaum.presentation.core.ui.composable.card.DetailsHealthCard
import dev.yaaum.presentation.core.ui.composable.card.SimplifiedHealthCard
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import dev.yaaum.presentation.feature.applications.screen.detalization.mvi.ApplicationDetalizationMviContent
import dev.yaaum.presentation.feature.applications.screen.detalization.mvi.ApplicationDetalizationMviState
import io.github.serpro69.kfaker.Faker

@Composable
fun ApplicationDetalizationFetchedContent(
    state: ApplicationDetalizationMviState,
    onBackClick: (() -> Unit)? = null,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(YaaumTheme.colors.background)
            .padding(horizontal = YaaumTheme.spacing.medium),
        verticalArrangement = Arrangement
            .spacedBy(YaaumTheme.spacing.small),
    ) {
        state.content?.data?.let {
            ApplicationDetalizationCard(
                modifier = Modifier
                    .padding(top = YaaumTheme.spacing.small),
                applicationsUiModel = it,
                onBackClick = onBackClick,
            )
        }
        SimplifiedHealthCard(
            healthStatus = state.content?.health,
        )
        DetailsHealthCard(
            state.content?.weekUsageStatics,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationFetchedContent_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        ApplicationDetalizationFetchedContent(
            state = ApplicationDetalizationMviState.fetched(
                content = ApplicationDetalizationMviContent(
                    data = ApplicationsUiModel(
                        uuid = null,
                        packageName = faker.quote.fortuneCookie(),
                        applicationName = faker.quote.fortuneCookie(),
                        isChosen = false,
                    ),
                    packageName = faker.quote.fortuneCookie(),
                    weekUsageStatics = null,
                    health = null,
                ),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationFetchedContent_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        ApplicationDetalizationFetchedContent(
            state = ApplicationDetalizationMviState.fetched(
                content = ApplicationDetalizationMviContent(
                    data = ApplicationsUiModel(
                        uuid = null,
                        packageName = faker.quote.fortuneCookie(),
                        applicationName = faker.quote.fortuneCookie(),
                        isChosen = false,
                    ),
                    packageName = faker.quote.fortuneCookie(),
                    weekUsageStatics = null,
                    health = null,
                ),
            ),
        )
    }
}
