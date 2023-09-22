package dev.yaaum.data.repository.configuration

import dev.yaaum.data.repository.configuration.model.ConfigurationRepoModel
import dev.yaaum.data.repository.core.exception.base.BaseRepoException
import kotlin.jvm.Throws

interface ConfigurationRepository {

    /**
     * Return configuration from local storage
     *
     * @return configuration
     *
     * @throws BaseRepoException
     */
    @Throws(BaseRepoException::class)
    suspend fun getCurrentConfiguration(): ConfigurationRepoModel?

    /**
     * Update exist configuration or add new one
     *
     * @param value configuration to set or update
     *
     * @throws BaseRepoException
     */
    @Throws(BaseRepoException::class)
    suspend fun setOrUpdateConfiguration(value: ConfigurationRepoModel)
}
