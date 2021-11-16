package de.jlnstrk.transit.api.trias

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import nl.adaptivity.xmlutil.QName
import nl.adaptivity.xmlutil.XmlReader
import nl.adaptivity.xmlutil.XmlStreaming
import nl.adaptivity.xmlutil.serialization.InputKind
import nl.adaptivity.xmlutil.serialization.UnknownChildHandler
import nl.adaptivity.xmlutil.serialization.XML

public interface TriasEndpoint {

    /*suspend fun openRequest(@Body trias: Trias): Trias

    suspend fun serviceRequest(@Body serviceRequest: ServiceRequest): ServiceDelivery

    suspend fun subscriptionRequest(@Body subscriptionRequest: SubscriptionRequest): SubscriptionRequest*/
}

public fun main() {
    /*val trias = Trias.RequestBase.Service.Request(
        serviceRequest = ServiceRequest(
            requestPayload = RequestPayload.LocationInformation(
                locationInformationRequest = LocationInformationRequest(
                    initialInput = InitialLocationInput(
                        locationName = "Frauenkirche"
                    )
                )
            ),
            requestTimestamp = LocalDateTime.now(),
            requestorRef = ParticipantRef("Hello!")
        )
    )

    val format = XML {
        unknownChildHandler = object : UnknownChildHandler {
            override fun invoke(
                input: XmlReader,
                inputKind: InputKind,
                name: QName?,
                candidates: Collection<Any>
            ) {

            }
        }
    }

    val input =
        "<trias:Trias version=\"1.1\" xmlns:trias=\"http://www.vdv.de/trias\"><trias:ServiceRequest><siri:RequestTimestamp xmlns:siri=\"http://www.siri.org.uk/siri\">2021-06-08T01:57:29.087839</siri:RequestTimestamp><siri:RequestorRef xmlns:siri=\"http://www.siri.org.uk/siri\">Hello!</siri:RequestorRef><trias:RequestPayload><trias:LocationInformationRequest><trias:InitialInput><trias:LocationName>Frauenkirche</trias:LocationName></trias:InitialInput></trias:LocationInformationRequest></trias:RequestPayload></trias:ServiceRequest></trias:Trias>"

    val triasUrl = "https://api.opentransportdata.swiss/trias2020"

    val request = URL(triasUrl).openConnection() as HttpURLConnection
    request.requestMethod = "POST"
    request.doOutput = true
    request.setRequestProperty("Content-Type", "application/xml; charset=UTF-8")
    request.setRequestProperty(
        "Authorization",
        "???"
    )


    val string = format.encodeToString(trias)
    println(string)
    request.outputStream.write(input.encodeToByteArray())
    request.outputStream.flush()

    val response =
        format.decodeFromReader<Trias>(XmlStreaming.newReader(request.inputStream.reader()))

    response

    val decoded = format.decodeFromString<Trias>(
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Trias version=\"1.4\" xmlns=\"http://www.vdv.de/trias\" xmlns:siri=\"http://www.siri.org.uk/siri\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "    <ServiceRequest>\n" +
                "        <siri:RequestTimestamp>2021-06-06T05:39:18.804Z</siri:RequestTimestamp>\n" +
                "        <siri:RequestorRef>API-Explorer</siri:RequestorRef>\n" +
                "        <RequestPayload>\n" +
                "            <StopEventRequest>\n" +
                "                <Location>\n" +
                "                    <LocationRef>\n" +
                "                        <StopPointRef>8507000</StopPointRef>\n" +
                "                    </LocationRef>\n" +
                "                    <DepArrTime>2021-06-06T07:39:18</DepArrTime>\n" +
                "                </Location>\n" +
                "                <Params>\n" +
                "                    <NumberOfResults>1</NumberOfResults>\n" +
                "                    <StopEventType>departure</StopEventType>\n" +
                "                    <IncludePreviousCalls>true</IncludePreviousCalls>\n" +
                "                    <IncludeOnwardCalls>true</IncludeOnwardCalls>\n" +
                "                    <IncludeRealtimeData>true</IncludeRealtimeData>\n" +
                "                </Params>\n" +
                "            </StopEventRequest>\n" +
                "        </RequestPayload>\n" +
                "    </ServiceRequest>\n" +
                "</Trias>"
    )
    decoded*/
}