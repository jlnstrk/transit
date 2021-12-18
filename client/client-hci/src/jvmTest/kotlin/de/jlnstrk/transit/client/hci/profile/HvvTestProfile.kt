package de.jlnstrk.transit.client.hci.profile

import de.jlnstrk.transit.client.hci.BuildKonfig
import de.jlnstrk.transit.client.hci.LineMatchTest
import de.jlnstrk.transit.client.hci.LocMatchTest
import de.jlnstrk.transit.client.hci.base.HciTestProfile
import de.jlnstrk.transit.client.hci.HciAuth
import de.jlnstrk.transit.client.hci.HciClient
import de.jlnstrk.transit.client.hci.HciConfig

val HVV = HciTestProfile("HVV") {
    config = HciConfig {
        baseUrl = "https://hvv-app.hafas.de/bin/"
        ver = "1.18"
        ext = "HVV.1"
        client = HciClient(
            type = HciClient.Type.AND,
            id = "HVV",
            name = "HVVPROD_ADHOC",
            v = "4020100"
        )
        auth = HciAuth.AccessId(aid = BuildKonfig.HVV_AID!!)
        salt = BuildKonfig.HVV_SALT!!
    }

    testData(
        LineMatchTest.DataSet(
            // Match S1, S11
            findSelfInput = "S1",
            // Match S lines
            findOthersOnlyInput = "S"
        ),

        LocMatchTest.DataSet.StationIdMatch(matchExtId = 20626, findNameContains = "Altona"),
        LocMatchTest.DataSet.StationNameMatch(matchName = "Barmbek", findExtId = 4933)
    )
}