package dev.yaaum.data.repository.configuration

import dev.yaaum.data.core.exception.base.BaseDataException
import dev.yaaum.data.repository.configuration.model.ConfigurationRepoModel
import kotlin.jvm.Throws

interface ConfigurationRepository {

    /**
     * Return configuration from local storage
     *
     * @return configuration
     *
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun getCurrentConfiguration(): ConfigurationRepoModel?

    /**
     * Update exist configuration or add new one
     *
     * @param value configuration to set or update
     *
     * @throws BaseDataException
     */
    @Throws(BaseDataException::class)
    suspend fun setOrUpdateConfiguration(value: ConfigurationRepoModel)
}
