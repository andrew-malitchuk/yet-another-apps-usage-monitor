package dev.yaaum.data.source.datastore.configuration.model

import dev.yaaum.data.source.datastore.core.model.base.BaseDataStoreModel
import kotlinx.serialization.Serializable

/**
 * Represent application configuration which can be modified by user
 */
@Serializable
data class ConfigurationDataStoreModel(
    val themeMode: String? = null,
) : BaseDataStoreModel
