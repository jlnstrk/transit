package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.HciCompat
import de.jlnstrk.transit.client.hci.model.composition.*
import de.jlnstrk.transit.client.hci.model.geo.HciCoordSystem
import de.jlnstrk.transit.client.hci.model.geo.HciLayer
import de.jlnstrk.transit.client.hci.model.geo.HciMapLayer
import de.jlnstrk.transit.client.hci.model.graph.HciGraph
import de.jlnstrk.transit.client.hci.model.graph.HciStructGraphEdge
import de.jlnstrk.transit.client.hci.model.graph.HciStructGraphNode
import de.jlnstrk.transit.client.hci.model.him.*
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import kotlinx.serialization.Serializable

@HciModel("1.39")
@Serializable
public data class HciCommon(
    /** Coordinate systems referred to in the response */
    @HciCompat(safeUntilAtLeast = "1.24")
    public val crdSysL: List<HciCoordSystem> = emptyList(),

    /** Directions used in tne response */
    public val dirL: List<HciDirection> = emptyList(),

    /** GUI elements referred to in the response */
    public val elmL: List<HciGuiElement> = emptyList(),

    /** Events referred to in the response */
    public val evtL: List<HciEvent> = emptyList(),

    /** External contents referred to in the response */
    public val extContL: List<HciExternalContent> = emptyList(),

    /** Global tags referred to in the response */
    public val gTagL: List<String> = emptyList(),

    /** Graphs referred to in the response */
    @HciCompat(safeFromAtLeast = "1.42")
    public val graphL: List<HciGraph> = emptyList(),

    /** HIM messages referred to in the response */
    public val himL: List<HciHimMessage> = emptyList(),

    /** HIM message categories referred to in the response */
    public val himMsgCatL: List<HciHimMessageCategory> = emptyList(),

    /** HIM message edges referred to in the response */
    public val himMsgEdgeL: List<HciHimMessageEdge> = emptyList(),

    /** HIM message events referred to in the response */
    public val himMsgEventL: List<HciHimMessageEvent> = emptyList(),

    /** HIM message regions referred to in the response */
    @HciCompat("1.41")
    public val himMsgRegionL: List<HciHimMessageRegion> = emptyList(),

    /** Icons referred to in the response */
    public val icoL: List<HciIcon> = emptyList(),

    /** (Legacy-) Layers referred to in the response */
    @HciCompat(safeUntilAtLeast = "1.24")
    public val layerL: List<HciLayer> = emptyList(),

    /** Line drawable styles referred to in the response */
    @HciCompat("1.24")
    public val lDrawStyleL: List<HciDrawableLineStyle> = emptyList(),

    /** Locations referred to in the response */
    public val locL: List<HciLocation> = emptyList(),

    /** Map layers referred to in the response */
    public val mapLayerL: List<HciMapLayer> = emptyList(),

    /** Operators referred to in the response */
    public val opL: List<HciOperator> = emptyList(),

    /** Polylines referred to in the response */
    public val polyL: List<HciPolyline> = emptyList(),

    /** Products referred to in the response */
    public val prodL: List<HciProduct> = emptyList(),

    /** Providers referred to in the response */
    public val prvL: List<HciProvider> = emptyList(),

    /** Remarks referred to in the response */
    public val remL: List<HciRemark> = emptyList(),

    /** Revitalized locations referred to in the response */
    public val reqLocL: List<HciRevitalizedLocation> = emptyList(),

    /** Realtime sources referred to in the response */
    public val rtSrcL: List<HciRtSource> = emptyList(),

    /** STC cars referred to in the response */
    public val stcCarL: List<HciStcCar> = emptyList(),

    /** STC graphs referred to in the response */
    public val stcGrpL: List<HciStcGroup> = emptyList(),

    /** STC legend items referred to in the response */
    public val stcLiL: List<HciStcLegendItem> = emptyList(),

    /** STC Or(?) legend items referred to in the response */
    public val stcLiOrL: List<HciStcLegendItem> = emptyList(),

    /** STC outputs referred to in the response */
    public val stcOL: List<HciStcOutput> = emptyList(),

    /** Struct graph edges referred to in the response */
    public val structGraphEdgeL: List<HciStructGraphEdge> = emptyList(),

    /** Struct graph nodes referred to in the response */
    public val structGraphNodeL: List<HciStructGraphNode> = emptyList(),

    /** Subgraphs referred to in the response */
    @HciCompat("1.42")
    public val subGraphL: List<HciGraph> = emptyList(),

    // TODO: What is this?
    public val tcctL: List<HciTrainComposition.CT> = emptyList(),

    // TODO: What is this?
    public val tcgL: List<HciTrainComposition.G> = emptyList(),

    /** TC load information referred to in the response */
    @HciCompat("1.34")
    public val tcocL: List<HciTrainComposition.OC> = emptyList(),

    // TODO: What is this?
    public val tcpdL: List<HciTrainComposition.PD> = emptyList(),

    // TODO: What is this?
    public val tctcL: List<HciTrainComposition.TC> = emptyList(),

    /** Time styles referred to in the response */
    @HciCompat("1.44")
    public val timeStyleL: List<HciTimeStyle> = emptyList(),

    /** Traffic messages referred to in the response */
    public val trffMsgL: List<HciTrafficMessage> = emptyList(),

    /** Text instructions referred to in the response */
    @HciCompat("1.27")
    public val txtInstL: List<HciTextInstruction> = emptyList(),

    /** URLs referred to in the response */
    public val urlL: List<HciUrl> = emptyList(),

    /** Views referred to in the response */
    @HciCompat("1.42")
    public val viewL: List<HciView> = emptyList(),
)