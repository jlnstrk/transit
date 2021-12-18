package de.jlnstrk.transit.client.efa.request.feature

import de.jlnstrk.transit.client.efa.model.EfaMeansOfTransport
import de.jlnstrk.transit.client.efa.request.EfaRequestMap
import de.jlnstrk.transit.client.efa.request.EfaRequestMapDelegate

internal interface EfaMeansCheckboxRequest {
    var includedMeans: Set<EfaMeansOfTransport>
    var excludedMeans: Set<EfaMeansOfTransport>

    class MapDelegate internal constructor(
        override val queryMap: EfaRequestMap
    ) : EfaMeansCheckboxRequest,
        EfaRequestMapDelegate {
        override var includedMeans: Set<EfaMeansOfTransport>
            get() = getMeans("inclMOT_")
            set(value) {
                // CLear any excludes
                queryMap.remove(PARAM_EXCLUDED_MEANS)
                clearMeans("exclMOT_")

                // Set the includes
                queryMap[PARAM_INCLUDED_MEANS] = PARAM_VALUE_CHECKBOX
                setMeans("inclMOT_", value)
            }
        override var excludedMeans: Set<EfaMeansOfTransport>
            get() = getMeans("exclMOT_")
            set(value) {
                // Clear any includes
                queryMap.remove(PARAM_INCLUDED_MEANS)
                clearMeans("inclMOT_")

                // Set the excludes
                queryMap[PARAM_EXCLUDED_MEANS] = PARAM_VALUE_CHECKBOX
                setMeans("exclMOT_", value)
            }

        private fun setMeans(
            keyPrefix: String,
            means: Set<EfaMeansOfTransport>
        ) {
            for (item in MEANS) {
                val key = keyPrefix + item.ordinal
                if (item in means) {
                    queryMap[key] = "1"
                } else {
                    queryMap.remove(key)
                }
            }
        }

        private fun clearMeans(keyPrefix: String) {
            for (means in MEANS) {
                queryMap.remove(keyPrefix + means.ordinal)
            }
        }

        private fun getMeans(keyPrefix: String): Set<EfaMeansOfTransport> {
            val set = mutableSetOf<EfaMeansOfTransport>()
            for (means in MEANS) {
                if (queryMap[keyPrefix + means.ordinal] == "1") {
                    set.add(means)
                }
            }
            return set
        }

        companion object {
            private const val PARAM_INCLUDED_MEANS = "includedMeans"
            private const val PARAM_EXCLUDED_MEANS = "excludedMeans"
            private const val PARAM_VALUE_CHECKBOX = "checkbox"
            private val MEANS: Array<EfaMeansOfTransport> = EfaMeansOfTransport.values()
        }
    }
}