package de.jlnstrk.transit.client.hci.method.generictripsearch

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.HciServiceResult
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public class HciGenericTripSearchServiceResult() : HciServiceResult()