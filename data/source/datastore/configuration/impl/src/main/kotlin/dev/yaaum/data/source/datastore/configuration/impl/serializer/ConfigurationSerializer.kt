package dev.yaaum.data.source.datastore.configuration.impl.serializer

import androidx.datastore.core.Serializer
import dev.yaaum.data.source.datastore.configuration.model.ConfigurationDataStoreModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

/**
 * I tried to use protobuf, but with no success; thus, i decide to use such duct-tape method.
 */
object ConfigurationSerializer : Serializer<ConfigurationDataStoreModel> {

    override val defaultValue: ConfigurationDataStoreModel
        get() = ConfigurationDataStoreModel()

    override suspend fun readFrom(input: InputStream): ConfigurationDataStoreModel {
        return try {
            Json.decodeFromString(
                deserializer = ConfigurationDataStoreModel.serializer(),
                string = input.readBytes().decodeToString(),
            )
        } catch (e: SerializationException) {
            defaultValue
        }
    }

    override suspend fun writeTo(value: ConfigurationDataStoreModel, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = ConfigurationDataStoreModel.serializer(),
                    value = value,
                ).encodeToByteArray(),
            )
        }
    }
}
