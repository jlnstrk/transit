package de.jlnstrk.transit.client.hci

@Target(AnnotationTarget.FIELD, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
public annotation class HciCompat(
    val removedBefore: String = "",
    val removedAfter: String = "",
    val removed: String = "",
)