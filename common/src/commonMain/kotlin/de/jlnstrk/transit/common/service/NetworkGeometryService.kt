package de.jlnstrk.transit.common.service

import de.jlnstrk.transit.common.Service

public interface NetworkGeometryService : Service {

    public suspend fun networkGeometry(): NetworkGeometryResult

    public enum class Error
}