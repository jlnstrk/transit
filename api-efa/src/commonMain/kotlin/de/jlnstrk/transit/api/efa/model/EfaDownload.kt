@file:UseSerializers(
    EfaPrimitiveSerializer.ForInt::class
)

package de.jlnstrk.transit.api.efa.model

import de.jlnstrk.transit.api.efa.serializer.primitive.EfaPrimitiveSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
public data class EfaDownload(
    public val itdDownloadFile: File,
) {

    @Serializable
    public data class File(
        /** The relative download URL, append to the base URL to get the full URL */
        public val src: String,
        /** The size of the file in kilobytes */
        public val size: Int,
    )
}