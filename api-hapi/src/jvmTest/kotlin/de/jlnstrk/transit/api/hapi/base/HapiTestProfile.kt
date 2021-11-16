package de.jlnstrk.transit.api.hapi.base

import de.jlnstrk.transit.api.hapi.HapiConfig
import de.jlnstrk.transit.api.hapi.HapiEndpoint
import de.jlnstrk.transit.api.hapi.HapiService
import de.jlnstrk.transit.api.hapi.profile.RMV
import de.jlnstrk.transit.api.hapi.profile.VBB
import de.jlnstrk.transit.util.testing.ServiceTestProfile
import kotlin.reflect.KClass

internal class HapiTestProfile(override val name: String) : ServiceTestProfile<HapiEndpoint, HapiTestProfile.DataSet> {
    lateinit var config: HapiConfig

    override val testData: MutableMap<KClass<*>, MutableList<DataSet>> = mutableMapOf()

    interface DataSet

    override fun makeTestEndpoint(): HapiEndpoint {
        return HapiEndpoint(config).apply {
            httpClient = httpClient.config {
                install(HapiLogging)
            }
        }
    }

    fun testData(vararg data: DataSet) {
        for (dataSet in data) {
            testData[dataSet::class]?.add(dataSet) ?: run {
                testData[dataSet::class] = mutableListOf(dataSet)
            }
        }
    }

    internal companion object {
        internal val ALL_PROFILES = listOf(RMV, VBB)

        internal operator fun get(service: HapiService): List<HapiTestProfile> =
            ALL_PROFILES.filter { service in it.config.enabledServices }

        internal inline operator fun invoke(name: String, init: HapiTestProfile.() -> Unit): HapiTestProfile =
            HapiTestProfile(name).apply(init)
    }
}