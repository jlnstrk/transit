package de.jlnstrk.transit.api.efa.serializer

import de.jlnstrk.transit.api.efa.EfaEndpoint
import de.jlnstrk.transit.api.efa.model.EfaMeansOfTransport
import de.jlnstrk.transit.api.efa.model.EfaPin
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal class EfaPinAttributeAdapter(
    private val altCodeResolver: EfaEndpoint.AltCodeResolver?
) : KSerializer<EfaPin.Attribute> {
    private val delegate = EfaPin.Attribute.Other.serializer()
    override val descriptor: SerialDescriptor = delegate.descriptor

    override fun serialize(encoder: Encoder, value: EfaPin.Attribute) {
        throw UnsupportedOperationException()
    }

    override fun deserialize(decoder: Decoder): EfaPin.Attribute {
        val other = delegate.deserialize(decoder)
        val (key, value) = other
        val keySegments = key.split(":")
        return when (keySegments[0]) {
            "STOP_GLOBAL_ID" -> EfaPin.Attribute.StopGlobalId(value)
            "STOP_NAME_WITH_PLACE" -> EfaPin.Attribute.StopNameWithPlace(value)
            "STOP_MAJOR_MEANS" -> {
                if (altCodeResolver != null) {
                    altCodeResolver.resolveAltCode(value.toInt())?.let { means ->
                        EfaPin.Attribute.StopMajorMeans(means)
                    }
                }
                other
            }
            "STOP_MEANS_LIST" -> {
                if (altCodeResolver != null) {
                    val set = mutableSetOf<EfaMeansOfTransport>()
                    val altCodes = value.split(",")
                    for (code in altCodes) {
                        altCodeResolver.resolveAltCode(code.toInt())?.let { means ->
                            set.add(means)
                        }
                    }
                    EfaPin.Attribute.StopMeansList(set)
                }
                other
            }
            "STOP_TARIFF_ZONES" -> {
                val network = keySegments[1]
                return EfaPin.Attribute.StopTariffZones(
                    network, value.split(',')
                        .map(String::toInt)
                        .toIntArray()
                )
            }
            "STOP_SURROUNDING_MAP" -> EfaPin.Attribute.StopSurroundingMap(value)
            else -> other
        }
    }
}