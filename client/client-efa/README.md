# api-efa

### Kotlin multiplatform bindings for EFA (Elektronische Fahrplanauskunft)

Requires Ktor clients for each applied target.

#### Supported requests

* XML_STOPFINDER_REQUEST
* XML_COORD_REQUEST
* XML_DM_REQUEST
* XML_TRIP_REQUEST2
* XML_ADDINFO_REQUEST
* XML_PS_REQUEST2
* XML_STT_REQUEST

#### (For now) Unsupported requests
* XML_STOPSEQCOORD_REQUEST

#### Won't be added
* XML_STOPLIST_REQUEST (No JSON :/)
* XML_DMTTP_REQUEST (No JSON :/)
* XML_MAP_REQUEST (No JSON :/)
* XML_SYSTEMINFO_REQUEST (No JSON :/)