package de.jlnstrk.transit.util

public open class LazySortedSet<T> private constructor(
    private val comparator: Comparator<T>,
    private val backing: LinkedHashSet<T>
) : MutableSet<T> by backing {
    private var isDirty: Boolean = false

    public constructor(
        comparator: Comparator<T>,
        vararg elements: T
    ) : this(comparator, elements.toCollection(LinkedHashSet()))

    final override val size: Int get() = backing.size

    final override fun add(element: T): Boolean {
        return backing.add(element).also {
            isDirty = isDirty or it
        }
    }

    final override fun addAll(elements: Collection<T>): Boolean {
        return backing.addAll(elements).also {
            isDirty = isDirty or it
        }
    }

    final override fun clear() {
        backing.clear()
        isDirty = false
    }

    final override fun iterator(): MutableIterator<T> {
        if (isDirty) {
            isDirty = false
            val sorted = sortedWith(comparator)
            clear()
            sorted.toCollection(backing)
        }
        return backing.iterator()
    }
}