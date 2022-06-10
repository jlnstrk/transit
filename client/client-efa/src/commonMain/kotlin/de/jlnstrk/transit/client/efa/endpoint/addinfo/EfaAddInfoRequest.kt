package de.jlnstrk.transit.client.efa.endpoint.addinfo

import de.jlnstrk.transit.client.efa.model.EfaMeansOfTransport
import de.jlnstrk.transit.client.efa.model.EfaTravelInfo
import de.jlnstrk.transit.client.efa.request.EfaRequest
import de.jlnstrk.transit.client.efa.request.EfaRequestMap
import de.jlnstrk.transit.client.efa.request.delegate.*
import de.jlnstrk.transit.client.efa.request.delegate.EfaBooleanParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaEnumMultiParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaEnumParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaIntParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaQueryMultiParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaQueryParam
import de.jlnstrk.transit.client.efa.request.delegate.EfaStringMultiParam
import de.jlnstrk.transit.client.efa.util.EFA_DATE_FORMAT_DASH_SEP
import kotlinx.datetime.LocalDate

public class EfaAddInfoRequest(
    queryMap: EfaRequestMap = EfaRequestMap()
) : EfaRequest(queryMap) {
    /**
     * Filtert nach Meldungen, die für einen bestimmten Tag gültig sind. Das Datum wird über die
     * zweistellige Angabe des Tages, gefolgt von der zweistelligen Angabe des Monats und der
     * vierstelligen Angabe des Jahres, angegeben. Als Separator dient das Minuszeichen. Der
     * Parameter kann mehrfach verwendet werden.
     */
    public var filterDateValid: Set<LocalDate> by EfaQueryMultiParam(
        serialize = { EFA_DATE_FORMAT_DASH_SEP.formatDate(it) },
        deserialize = { EFA_DATE_FORMAT_DASH_SEP.parseDate(it) },
    )

    /**
     * Ausschließlich aktuelle Meldungen ([CURRENT]) oder abgelaufene Meldungen ([HISTORY])
     * anzeigen.
     */
    public var filterPublicationStatus: EfaAddInfoResponse.AdditionalInfo.PublicationStatus? by EfaEnumParam()

    /**
     * Diese Parameter geben ein Datumsintervall an. Es werden ausschließlich Meldungen ausgegeben,
     * die innerhalb des angegebenen Intervalls liegen. Das Start- bzw. End-Datum wird über die
     * zweistellige Angabe des Tages, gefolgt von der zweistelligen Angabe des Monats und der
     * vierstelligen Angabe des Jahres, angegeben. Als Separator dient das Minuszeichen.
     */
    public var filterValidIntervalStart: LocalDate? by EfaDateParam(EFA_DATE_FORMAT_DASH_SEP)
    public var filterValidIntervalEnd: LocalDate? by EfaDateParam(EFA_DATE_FORMAT_DASH_SEP)

    /**
     * Filtert nach Meldungen, die bestimmte Orte betreffen. Der Wert des Filters ist eine Liste von
     * Gemeindekennziffern (GKZ bzw. OMC), die durch einen Doppelpunkt voneinander getrennt werden.
     * Auf diese Weise können beispielsweise Landkreise modelliert werden.
     */
    public var filterOMC: Set<String>? by EfaQueryParam(
        serialize = { it.joinToString(separator = ":") },
        deserialize = { it.split(":").toSet() }
    )

    /**
     * Filtert nach Meldungen, die einen bestimmten Ort betreffen. Der Ort wird durch die
     * Gemeindekennziffer und eine ID des Ortes bestimmt. Die beiden Werte werden durch einen
     * Doppelpunkt getrennt angegeben. Der Parameter kann mehrfach verwendet werden.
     */
    @Suppress("PropertyName")
    public var filterOMC_PlaceID: Set<Pair<String, String>> by EfaQueryMultiParam(
        serialize = { (omc, placeId) -> "$omc:$placeId" },
        deserialize = { it.split(':').let { Pair(it[0], it[1]) } },
    )

    /**
     * Angabe eines Liniennummer-Intervalls. Es wird nach Meldungen gefiltert, die Linien betreffen,
     * deren Liniennummern (entspricht den letzten 3 Stellen der DIV-Linie) in dem Intervall liegen.
     * Der Wert der Parameter muss größer als Null sein und kann maximal 999 sein, außerdem muss der
     * Wert von filterLineNumberIntervalEnd größer sein als der von filterLineNumberIntervalStart.
     */
    public var filterLineNumberIntervalStart: Int? by EfaIntParam
    public var filterLineNumberIntervalEnd: Int? by EfaIntParam

    /**
     * Filtert nach Meldungen, die ein bestimmtes Verkehrsmittel betreffen. Zur Wahl mehrerer
     * Verkehrsmittel, wird der Parameter mehrfach verwendet. Als Wert des Parameters wird die
     * Verkehrsmittel-ID angegeben.
     */
    public var filterMOTType: Set<EfaMeansOfTransport> by EfaQueryMultiParam(
        serialize = { it.ordinal.toString() },
        deserialize = { EfaMeansOfTransport.values()[it.toInt()] }
    )

    /**
     * Dieser Parameter wählt eine Linie aus. Er kann mehrfach übergeben werden. Sein Wert setzt
     * sich zusammen aus dem Teilnetz, der DIVA Liniennummer, der Ergänzung, der Richtung und dem
     * Fahrplanprojekt, getrennt durch Doppelpunkte. Für die Ergänzung gilt zu beachten, dass der
     * Unterstrich "_" durch ein Leerzeichen " " ersetzt werden muss.
     *
     * Mit dem Parameter passedStops=1 können dann Meldungen zurückgegeben werden, die die
     * durchfahrenen Haltestellen der ausgewählten Linien betreffen.
     */
    public var line: Set<String> by EfaStringMultiParam
    public var passedStops: Boolean? by EfaBooleanParam

    /**
     * Mit dem Parameter kann eine bestimmte Meldung anhand ihrer ID gesucht werden.
     * Die ID wird als Wert des Parameters übergeben. Der Parameter kann zur Suche mehrerer
     * Meldungen mehrfach verwendet werden.
     */
    public var filterInfoID: Set<String> by EfaStringMultiParam

    /**
     * Filtert nach Meldungen eines bestimmten Typs.
     */
    public var filterInfoType: Set<EfaTravelInfo.Type> by EfaEnumMultiParam()

    /**
     * Filtert nach Meldungen, die von einen bestimmten Autor oder Anbieter eingegeben oder zur
     * Verfügung gestellt wurden. Zur Wahl mehrerer Betreiber, wird der Parameter mehrfach
     * verwendet. Als Wert wir der Code des Autors bzw. Anbieters übergeben.
     */
    public var filterProviderCode: Set<String> by EfaStringMultiParam

    /**
     * Filtern nach Meldungen, die von dem als Wert übergebenen Quellsystem eingegeben wurden.
     * Der Parameter kann mehrfach verwendet werden.
     */
    public var filterSourceSystemName: Set<String> by EfaStringMultiParam
}