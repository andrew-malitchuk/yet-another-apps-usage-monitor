package dev.yaaum.data.repository.configuration

import dev.yaaum.data.repository.configuration.model.ConfigurationRepoModel
import dev.yaaum.data.repository.core.exception.base.BaseRepoException
import kotlin.jvm.Throws

interface ConfigurationRepository {

    @Throws(BaseRepoException::class)
    suspend fun getCurrentConfiguration(): ConfigurationRepoModel?

    @Throws(BaseRepoException::class)
    suspend fun setOrUpdateConfiguration(value: ConfigurationRepoModel)
}
