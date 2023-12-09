package dev.yaaum.presentation.feature.main.screen

import dev.yaaum.domain.configuration.GetCurrentConfigurationUseCase
import dev.yaaum.domain.configuration.model.ConfigurationDomainModel
import dev.yaaum.presentation.core.models.ConfigurationUiModel
import dev.yaaum.presentation.core.models.ThemeUiModel
import dev.yaaum.presentation.core.models.toUiModel
import dev.yaaum.presentation.core.platform.vm.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HostViewModel(
    private val getCurrentConfigurationUseCase: GetCurrentConfigurationUseCase,
) : BaseViewModel() {

    private var configurationStateFlow: StateFlow<ConfigurationUiModel?> =
        MutableStateFlow(null)

    private var isConfigurationLoadingStateFlow: StateFlow<Boolean?> = MutableStateFlow(true)

    // TODO: recode using combine when other stuff will be loaded soon
    var isSetupLoadingStateFlow: Flow<Boolean?> = isConfigurationLoadingStateFlow

    var currentThemeUiModel: StateFlow<ThemeUiModel?> =
        MutableStateFlow(null)

    var isOnboardingFinished: StateFlow<Boolean?> = MutableStateFlow(null)

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
            result = { result ->
                result?.let {
                    isOnboardingFinished.setValue(it.isOnboardingFinished)
                }
                configurationStateFlow.setValue(result?.toUiModel())
                currentThemeUiModel.setValue(result?.toUiModel()?.themeMode)
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
