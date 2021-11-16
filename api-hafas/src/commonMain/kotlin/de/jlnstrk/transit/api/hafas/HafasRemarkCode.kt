package de.jlnstrk.transit.api.hafas

import kotlinx.serialization.Serializable

@Serializable
public enum class HafasRemarkCode {
    // Bicycles
    /** Bicycle carriage */
    FB, FK,

    /** Bicycle carriage reserved */
    FR,

    // Reservation & class
    /** Reservation possible */
    RC,

    /** Reservation mandatory */
    RP,

    /** Only second class */
    K2,

    /** Sleeping coach */
    SL,

    // Accessibility
    /** Guide strips */
    BL,

    /** Access aid */
    EH,

    /** Access aid in center */
    ZM,

    /** Access ramp */
    ER,

    /** Accessible */
    RG, WA, EA, BE,

    /** Accessible WC */
    OC,

    /** Wheelchair space */
    RO,

    // Onboard services */
    /** WC */
    TO,

    /** Onboard entertainment */
    EE,

    /** WIFI */
    WV,

    /** WIFI international */
    WI,

    /** AC */
    KL,

    /** Sockets */
    LS,

    /** Ticket machine */
    FM,

    /** Onboard bistro */
    BT,

    /** Onboard restaurant */
    BR,

    /** Snacks & beverages */
    SN, MB,

    /** No gastronomy */
    KG,

    // Journey characteristics
    /** Replacement */
    EV,

    // Station characteristics */
    /** Elevator */
    AT,

    /** Escalator */
    FT,
}