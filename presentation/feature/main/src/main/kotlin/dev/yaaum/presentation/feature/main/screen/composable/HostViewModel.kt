package dev.yaaum.presentation.feature.main.screen.composable

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import dev.yaaum.domain.configuration.GetCurrentConfigurationUseCase
import dev.yaaum.domain.configuration.model.ConfigurationDomainModel
import dev.yaaum.presentation.core.models.ConfigurationUiModel
import dev.yaaum.presentation.core.models.ThemeUiModel
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.viewmodel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HostViewModel(
    private val getCurrentConfigurationUseCase: GetCurrentConfigurationUseCase,
) : BaseViewModel() {

    var configurationStateFlow: StateFlow<ConfigurationUiModel?> =
        MutableStateFlow(null)

    private var isConfigurationLoadingStateFlow: StateFlow<Boolean?> = MutableStateFlow(true)

    // TODO: recode using combine when other stuff will be loaded soon
    var isSetupLoadingStateFlow: Flow<Boolean?> = isConfigurationLoadingStateFlow

    var currentThemeUiModel: MutableState<ThemeUiModel?> =
        mutableStateOf(null)

    init {
        setup()
    }

    private fun getConfiguration() {
        launch(
            request = {
                // TODO: remove dummy loading
                @Suppress("MagicNumber")
                delay(1_500L)
                getCurrentConfigurationUseCase().getOrNull() ?: ConfigurationDomainModel()
            },
            result = {
                configurationStateFlow.setValue(it?.toUiModel())
                currentThemeUiModel.value = it?.toUiModel()?.themeMode
            },
            errorBlock = {
                it.toString()
                ConfigurationDomainModel()
            },
            loading = {
                isConfigurationLoadingStateFlow.setValue(it)
            },
        )
    }

    private fun setup() {
        getConfiguration()
    }
}
