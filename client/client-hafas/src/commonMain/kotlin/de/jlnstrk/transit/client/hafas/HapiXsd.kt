package de.jlnstrk.transit.client.hafas

/** Marks a model class as up-to-date with Hafas OpenAPI xsd version [version] */
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS)
@Retention(AnnotationRetention.SOURCE)
public annotation class HapiXsd(val version: String)