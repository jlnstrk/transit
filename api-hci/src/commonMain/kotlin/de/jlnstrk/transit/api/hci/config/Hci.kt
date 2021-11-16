package de.jlnstrk.transit.api.hci.config


@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.CLASS,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.SOURCE)
internal annotation class Hci(val fromVersion: String, val upToVersion: String = "")