package de.jlnstrk.transit.client.hci

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