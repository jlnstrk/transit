package de.jlnstrk.transit.sample

import com.soywiz.klock.TimezoneOffset
import com.soywiz.klock.hours
import de.jlnstrk.transit.client.hci.HciAuth
import de.jlnstrk.transit.client.hci.HciClient
import de.jlnstrk.transit.client.hci.HciConfig
import de.jlnstrk.transit.common.model.Means
import de.jlnstrk.transit.common.model.ProductClass
import de.jlnstrk.transit.interop.hafas.HafasClassMapping
import de.jlnstrk.transit.interop.hci.HciProvider

object SampleProvider : HciProvider(), HafasClassMapping.OneToOne {
    override val config: HciConfig = HciConfig {
        baseUrl = "https://bvg-apps-ext.hafas.de/bin/"
        client = HciClient(
            type = HciClient.Type.IPA,
            id = "BVG",
            name = "FahrInfo",
            v = "6020000"
        )
        auth = HciAuth.AccessId(aid = BuildKonfig.BVG_AID!!)
        ver = "1.44"
        ext = "BVG.1"
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