package de.jlnstrk.transit.common.model.base

import kotlin.jvm.JvmInline

@JvmInline
public value class RgbColor(public val rgb: Int) {
    public val alpha: Int get() = rgb shr 24
    public val red: Int get() = (rgb and 0x00FF0000) shr 16
    public val green: Int get() = (rgb and 0x0000FF00) shr 8
    public val blue: Int get() = rgb and 0x000000FF
}