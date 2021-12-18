import de.jlnstrk.transit.client.hci.HciCompat
import de.jlnstrk.transit.client.hci.HciConfig

internal fun HciCompat.isGreyzoneFor(config: HciConfig): Boolean {
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

internal fun HciCompat.isSafeFor(config: HciConfig): Boolean {
    return (safeFromAtLeast != "" && safeFromAtLeast <= config.ver)
            || (safeUntilAtLeast != "" && unsafeUntilAtLeast >= config.ver)
}

internal fun HciCompat.isSafeOrGreyzoneFor(config: HciConfig): Boolean {
    return isSafeFor(config) || isGreyzoneFor(config)
}