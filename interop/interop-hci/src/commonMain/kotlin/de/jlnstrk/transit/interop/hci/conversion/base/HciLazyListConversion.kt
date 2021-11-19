package de.jlnstrk.transit.interop.hci.conversion.base

internal fun <H, C> List<H>.lazyConversion(
    context: HciCommonContext,
    converter: (H, HciCommonContext) -> C
): HciLazyListConversion<H, C> {
    return HciLazyListConversion(context, this, converter)
}

internal class HciLazyListConversion<H, C>(
    private val context: HciCommonContext,
    private val source: List<H>,
    private val converter: (H, HciCommonContext) -> C
) {
    @Suppress("UNCHECKED_CAST")
    private val cache: Array<C?> = arrayOfNulls<Any?>(source.size) as Array<C?>

    internal operator fun get(index: Int): C {
        return cache[index] ?: kotlin.run {
            val converted = converter.invoke(source[index], context)
            cache[index] = converted
            converted
        }
    }

    internal val size: Int get() = source.size
}