package de.jlnstrk.transit.client.hci.profile

import de.jlnstrk.transit.client.hci.BuildKonfig
import de.jlnstrk.transit.client.hci.LineMatchTest
import de.jlnstrk.transit.client.hci.LocMatchTest
import de.jlnstrk.transit.client.hci.base.HciTestProfile
import de.jlnstrk.transit.client.hci.HciConfig
import de.jlnstrk.transit.client.hci.model.HciAuth
import de.jlnstrk.transit.client.hci.model.HciAuthType
import de.jlnstrk.transit.client.hci.model.HciExtension
import de.jlnstrk.transit.client.hci.model.HciVersion
import de.jlnstrk.transit.client.hci.model.client.HciClient
import de.jlnstrk.transit.client.hci.model.client.HciClientId
import de.jlnstrk.transit.client.hci.model.client.HciClientType

val HVV = HciTestProfile("HVV") {
    config = HciConfig {
        baseUrl = "https://hvv-app.hafas.de/bin/"
        ver = HciVersion._1_18
        ext = HciExtension.HVV_1
        client = HciClient(
            type = HciClientType.AND,
            id = HciClientId.HVV,
            name = "HVVPROD_ADHOC",
            v = 4020100
        )
        auth = HciAuth(
            type = HciAuthType.AID,
            aid = BuildKonfig.HVV_AID!!
        )
        salt = BuildKonfig.HVV_SALT!!
    }

    testData(
        LineMatchTest.TestData.FindSelf(
            // Match S1, S11
            findSelfInput = "S1",
            // Match S lines
            findOthersOnlyInput = "S"
        ),

        LocMatchTest.TestData.StationIdMatch(matchExtId = "20626", findNameContains = "Altona"),
        LocMatchTest.TestData.StationNameMatch(matchName = "Barmbek", findExtId = "4933")
    )
}