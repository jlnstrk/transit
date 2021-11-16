package de.jlnstrk.transit.util.service

import de.jlnstrk.transit.util.Service

public interface NetworkGeometryService : Service {

    public suspend fun networkGeometry(): NetworkGeometryResult

    public enum class Error
}