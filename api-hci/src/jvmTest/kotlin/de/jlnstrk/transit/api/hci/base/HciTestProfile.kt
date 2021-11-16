package de.jlnstrk.transit.api.hci.base

import de.jlnstrk.transit.api.hci.HciEndpoint
import de.jlnstrk.transit.api.hci.config.HciConfig
import de.jlnstrk.transit.api.hci.profile.BVG
import de.jlnstrk.transit.api.hci.profile.HVV
import de.jlnstrk.transit.api.hci.profile.RMV
import de.jlnstrk.transit.api.hci.profile.SBM
import de.jlnstrk.transit.util.testing.ServiceTestProfile
import kotlin.reflect.KClass

class HciTestProfile(override val name: String) : ServiceTestProfile<HciEndpoint, HciTestProfile.DataSet> {
    lateinit var config: HciConfig

    override var testData = mutableMapOf<KClass<*>, MutableList<DataSet>>()
        private set

    fun testData(vararg data: DataSet) {
        for (dataSet in data) {
            testData[dataSet::class]?.add(dataSet) ?: run {
                testData[dataSet::class] = mutableListOf(dataSet)
            }
        }
    }

    override fun makeTestEndpoint(): HciEndpoint = HciEndpoint(config).apply {
        httpClient = httpClient.config {
            install(HciLogging)
        }
    }

    interface DataSet

    companion object {
        val ALL_PROFILES = listOf(BVG, HVV, SBM, RMV)

        operator fun invoke(name: String, init: HciTestProfile.() -> Unit): HciTestProfile =
            HciTestProfile(name).apply(init)
    }
}