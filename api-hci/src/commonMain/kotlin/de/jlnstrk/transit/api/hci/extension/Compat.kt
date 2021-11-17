import de.jlnstrk.transit.api.hci.HciCompat
import de.jlnstrk.transit.api.hci.HciConfig

internal inline fun HciCompat.isGreyzoneFor(config: HciConfig): Boolean {
    if ((safeUntilAtLeast == "" || unsafeFromAtLeast == "")
        && (unsafeUntilAtLeast == "" || safeFromAtLeast == "")
    ) {
        throw IllegalArgumentException("Invalid HCI compat specification")
    }

    if (unsafeUntilAtLeast != "" && safeFromAtLeast != "") {
        return unsafeUntilAtLeast < config.ver && safeFromAtLeast > config.ver
    }
    if (safeUntilAtLeast != "" && unsafeFromAtLeast != "") {
        return safeUntilAtLeast < config.ver && unsafeFromAtLeast > config.ver
    }
    throw IllegalStateException()
}

internal inline fun HciCompat.isSafeFor(config: HciConfig): Boolean {
    return (safeFromAtLeast != "" && safeFromAtLeast <= config.ver)
            || (safeUntilAtLeast != "" && unsafeUntilAtLeast >= config.ver)
}

internal inline fun HciCompat.isSafeOrGreyzoneFor(config: HciConfig): Boolean {
    return isSafeFor(config) || isGreyzoneFor(config)
}