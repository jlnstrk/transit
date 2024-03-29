package de.jlnstrk.transit.common.model

import de.jlnstrk.transit.common.model.base.RgbColor

public data class Style(
    public val textColor: RgbColor?,
    public val backgroundColor: RgbColor?,
    public val shape: Shape?
) {

    public enum class Shape {
        CIRCLE,
        RECT,
        ROUND_RECT
    }
}