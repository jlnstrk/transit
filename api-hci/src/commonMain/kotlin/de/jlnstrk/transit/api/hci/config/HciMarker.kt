package de.jlnstrk.transit.api.hci.config

/**
 * [safeFromAtLeast] marks the lowest known version where present/working
 * [safeUntilAtLeast] marks the highest known version where present/working
 * [unsafeFromAtLeast] marks the lowest known version where not present/working
 * [unsafeUntilAtLeast] marks the highest known version where not present/working
 * */
@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
internal annotation class HciCompat(
    val safeFromAtLeast: String = "",
    val safeUntilAtLeast: String = "",
    val unsafeFromAtLeast: String = "",
    val unsafeUntilAtLeast: String = ""
)

internal inline fun HciCompat.isGreyzoneFor(config: HciConfig): Boolean {
    if ((safeUntilAtLeast == "" || unsafeFromAtLeast == "")
        && (unsafeUntilAtLeast == "" || safeFromAtLeast == "")) {
        throw IllegalArgumentException("Invalid HCI compat specification")
    }

    if (unsafeUntilAtLeast != "" && safeFromAtLeast != "") {
        return  unsafeUntilAtLeast < config.ver && safeFromAtLeast > config.ver
    }
    if (safeUntilAtLeast != "" && unsafeFromAtLeast != "") {
        return  safeUntilAtLeast < config.ver && unsafeFromAtLeast > config.ver
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

/**
 * [until] marks the exact last version where present/working
 * [before] marks the lowest known version where not present/working
 * */
@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
internal annotation class HciAtMost(val until: String = "", val before: String = "")
