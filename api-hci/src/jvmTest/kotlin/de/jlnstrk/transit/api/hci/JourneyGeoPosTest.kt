package de.jlnstrk.transit.api.hci

import de.jlnstrk.transit.api.hci.base.HciShouldSpec
import de.jlnstrk.transit.api.hci.base.HciTestProfile

internal class JourneyGeoPosTest : HciShouldSpec(HciTestProfile.ALL_PROFILES, { hci, profile ->
    /*given<DataSet>(profile) { dataSet ->
        shou("do nothing") {
            // do nothing
        }
    }*/
}) {

    data class DataSet(
        val abc: String
    ) : HciTestProfile.DataSet
}