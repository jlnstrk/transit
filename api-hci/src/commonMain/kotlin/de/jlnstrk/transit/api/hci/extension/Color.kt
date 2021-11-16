package de.jlnstrk.transit.api.hci.extension

import de.jlnstrk.transit.api.hci.model.HciColor

public val HciColor.rgb: Int get() = 0xFF000000.toInt() or (r shl 16) or (g shl 8) or b

public fun Int.asHciColor(): HciColor =
    HciColor((this and 0x00FF0000) shr 16, (this and 0x0000FF00) shr 8, this and 0x000000FF)