package de.jlnstrk.transit.sample

import com.soywiz.klock.TimezoneOffset
import com.soywiz.klock.hours
import de.jlnstrk.transit.client.hci.HciConfig
import de.jlnstrk.transit.client.hci.model.HciAuth
import de.jlnstrk.transit.client.hci.model.HciAuthType
import de.jlnstrk.transit.client.hci.model.HciExtension
import de.jlnstrk.transit.client.hci.model.HciVersion
import de.jlnstrk.transit.client.hci.model.client.HciClient
import de.jlnstrk.transit.client.hci.model.client.HciClientId
import de.jlnstrk.transit.client.hci.model.client.HciClientType
import de.jlnstrk.transit.common.model.Means
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.interop.hafas.HafasClassMapping
import de.jlnstrk.transit.interop.hci.HciProvider

object SampleProvider : HciProvider(), HafasClassMapping.OneToOne {
    override val config: HciConfig = HciConfig {
        baseUrl = "https://bvg-apps-ext.hafas.de/bin/"
        client = HciClient(
            type = HciClientType.IPA,
            id = HciClientId.BVG,
            name = "FahrInfo",
            v = 6020000
        )
        auth = HciAuth(
            type = HciAuthType.AID,
            aid = BuildKonfig.BVG_AID!!
        )
        ver = HciVersion._1_44
        ext = HciExtension.BVG_1
        timezone = TimezoneOffset(2.hours)
    }

    override val mapping: Array<ProductClass> = arrayOf(
        BerlinProduct.SBahn,
        BerlinProduct.UBahn,
        BerlinProduct.Tram,
        BerlinProduct.Bus,
        BerlinProduct.Faehre,
        Means.TRAIN,
        BerlinProduct.Bahn
    )
}