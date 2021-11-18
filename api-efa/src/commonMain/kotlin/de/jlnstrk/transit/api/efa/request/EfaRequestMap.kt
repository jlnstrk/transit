package de.jlnstrk.transit.api.efa.request

public class EfaRequestMap : MutableMap<String, String> {
    private val backing: MutableMap<String, MutableSet<String>> = HashMap()

    override var size: Int = 0
        private set

    override fun containsKey(key: String): Boolean = backing.containsKey(key)

    override fun containsValue(value: String): Boolean = backing.values.any { it.contains(value) }

    override fun get(key: String): String? = backing[key]?.joinToString(separator = "&$key=")

    public fun getAll(key: String): Set<String> = backing[key].orEmpty()

    override fun isEmpty(): Boolean = backing.isEmpty()

    override val entries: MutableSet<MutableMap.MutableEntry<String, String>>
        get() = backing.entries.map { (key, valueSet) ->
            object : MutableMap.MutableEntry<String, String> {
                override val key: String = key
                override val value: String = valueSet.joinToString(separator = "&$key=")
                override fun setValue(newValue: String): String {
                    put(key, newValue)
                    return newValue
                }
            }
        }.toMutableSet()

    override val keys: MutableSet<String> get() = backing.keys

    override val values: MutableCollection<String>
        get() = backing.values.flatten().toMutableList()

    override fun clear() {
        backing.clear()
        size = 0
    }

    override fun put(key: String, value: String): String? {
        backing[key]?.add(value) ?: run {
            backing[key] = mutableSetOf(value)
        }
        ++size
        return null
    }

    override fun putAll(from: Map<out String, String>) {
        for ((key, value) in from) {
            backing[key]?.add(key) ?: run {
                backing[key] = mutableSetOf(value)
            }
            ++size
        }
    }

    public fun putAll(key: String, values: Set<String>) {
        backing[key] = values.toMutableSet()
    }

    override fun remove(key: String): String? {
        --size
        return backing.remove(key)?.firstOrNull()
    }
}