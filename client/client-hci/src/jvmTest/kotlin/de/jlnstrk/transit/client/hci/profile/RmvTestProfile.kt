package de.jlnstrk.transit.client.hci.profile

import com.soywiz.klock.hours
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

val RMV = HciTestProfile("RMV") {
    config = HciConfig {
        timezone = ZoneOffset(2.hours)
        baseUrl = "https://www.rmv.de/auskunft/bin/jp/"
        ver = HciVersion._1_44
        ext = HciExtension.RMV_1
        client = HciClient(
            type = HciClientType.WEB,
            id = HciClientId.RMV,
            name = "webapp",
        )
        auth = HciAuth(
            type = HciAuthType.AID,
            aid = BuildKonfig.RMV_AID!!
        )
    }

    testData(
        LineMatchTest.TestData(
            findSelfInput = "M34",
            findOthersOnlyInput = "U"
        ),
        LocMatchTest.TestData.StationIdMatch(
            matchExtId = "3000525",
            findNameContains = "Ostendstraße"
        ),
        LocMatchTest.TestData.StationNameMatch(
            matchName = "Grüneburgweg",
            findExtId = "3000402"
        )
    )
}