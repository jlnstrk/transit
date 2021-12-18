package de.jlnstrk.transit.client.hafas

/** Marks a model class as up-to-date with HCI version [version] */
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS)
@Retention(AnnotationRetention.SOURCE)
public annotation class HciModel(val version: String)