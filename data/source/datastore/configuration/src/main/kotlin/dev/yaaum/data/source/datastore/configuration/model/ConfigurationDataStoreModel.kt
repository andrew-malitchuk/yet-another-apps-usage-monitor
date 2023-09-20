package dev.yaaum.data.source.datastore.configuration.model

import dev.yaaum.data.source.datastore.core.model.base.BaseDataStoreModel
import kotlinx.serialization.Serializable

@Serializable
data class ConfigurationDataStoreModel(
    val themeMode: ThemeMode = ThemeMode.NI,
) : BaseDataStoreModel

// data class Author private constructor(val name: String) {
//    companion object {
//        operator fun invoke(name: String): Either<EmptyAuthorName, Author> = TODO()
//    }
// }
