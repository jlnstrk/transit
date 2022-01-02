package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import de.jlnstrk.transit.client.hci.model.client.HciClientFilter
import de.jlnstrk.transit.client.hci.model.composition.HciSimpleTrainCompositionCar
import de.jlnstrk.transit.client.hci.model.composition.HciSimpleTrainCompositionGroup
import de.jlnstrk.transit.client.hci.model.composition.HciSimpleTrainCompositionLegendItem
import de.jlnstrk.transit.client.hci.model.composition.HciSimpleTrainCompositionOutput
import de.jlnstrk.transit.client.hci.model.composition.HciTrainCompositionCT
import de.jlnstrk.transit.client.hci.model.composition.HciTrainCompositionG
import de.jlnstrk.transit.client.hci.model.composition.HciTrainCompositionOC
import de.jlnstrk.transit.client.hci.model.composition.HciTrainCompositionPD
import de.jlnstrk.transit.client.hci.model.composition.HciTrainCompositionTC
import de.jlnstrk.transit.client.hci.model.event.HciEvent
import de.jlnstrk.transit.client.hci.model.geo.HciGeoData
import de.jlnstrk.transit.client.hci.model.gui.HciGuiElement
import de.jlnstrk.transit.client.hci.model.him.HciHimMessage
import de.jlnstrk.transit.client.hci.model.him.HciHimMessageCategory
import de.jlnstrk.transit.client.hci.model.him.HciHimMessageEdge
import de.jlnstrk.transit.client.hci.model.him.HciHimMessageEvent
import de.jlnstrk.transit.client.hci.model.him.HciHimMessageRegion
import de.jlnstrk.transit.client.hci.model.location.HciLocation
import de.jlnstrk.transit.client.hci.model.struct.HciStructGraphEdge
import de.jlnstrk.transit.client.hci.model.struct.HciStructGraphNode
import de.jlnstrk.transit.client.hci.model.text.HciTextInstruction
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciCommon(
  public val cFltrL: List<HciClientFilter> = emptyList(),
  public val dirL: List<HciDirection> = emptyList(),
  public val elmL: List<HciGuiElement> = emptyList(),
  public val evtL: List<HciEvent> = emptyList(),
  public val extContL: List<HciExternalContent> = emptyList(),
  public val gTagL: List<String> = emptyList(),
  public val geoDataL: List<HciGeoData> = emptyList(),
  public val graphL: List<HciGraph> = emptyList(),
  public val himL: List<HciHimMessage> = emptyList(),
  public val himMsgCatL: List<HciHimMessageCategory> = emptyList(),
  public val himMsgEdgeL: List<HciHimMessageEdge> = emptyList(),
  public val himMsgEventL: List<HciHimMessageEvent> = emptyList(),
  public val himMsgRegionL: List<HciHimMessageRegion> = emptyList(),
  public val icoL: List<HciIcon> = emptyList(),
  public val lDrawStyleL: List<HciDrawableLineStyle> = emptyList(),
  public val locL: List<HciLocation> = emptyList(),
  public val mapLayerL: List<HciMapLayer> = emptyList(),
  public val opL: List<HciOperator> = emptyList(),
  public val polyL: List<HciPolyline> = emptyList(),
  public val prodL: List<HciProduct> = emptyList(),
  public val prvL: List<HciProvider> = emptyList(),
  public val remL: List<HciRemark> = emptyList(),
  public val reqLocL: List<HciRevitalizedLocation> = emptyList(),
  public val rtSrcL: List<HciRealtimeDataSource> = emptyList(),
  public val stcCarL: List<HciSimpleTrainCompositionCar> = emptyList(),
  public val stcGrpL: List<HciSimpleTrainCompositionGroup> = emptyList(),
  public val stcLiL: List<HciSimpleTrainCompositionLegendItem> = emptyList(),
  public val stcLiOrL: List<HciSimpleTrainCompositionLegendItem> = emptyList(),
  public val stcOL: List<HciSimpleTrainCompositionOutput> = emptyList(),
  public val structGraphEdgeL: List<HciStructGraphEdge> = emptyList(),
  public val structGraphNodeL: List<HciStructGraphNode> = emptyList(),
  public val subGraphL: List<HciSubGraph> = emptyList(),
  public val tcctL: List<HciTrainCompositionCT> = emptyList(),
  public val tcgL: List<HciTrainCompositionG> = emptyList(),
  public val tcocL: List<HciTrainCompositionOC> = emptyList(),
  public val tcpdL: List<HciTrainCompositionPD> = emptyList(),
  public val tctcL: List<HciTrainCompositionTC> = emptyList(),
  public val timeStyleL: List<HciTimeDisplayStyle> = emptyList(),
  public val trffMsgL: List<HciTrafficMessage> = emptyList(),
  public val txtInstL: List<HciTextInstruction> = emptyList(),
  public val urlL: List<HciUrl> = emptyList(),
  public val viewL: List<HciView> = emptyList(),
  public val layerL: List<HciLayer> = emptyList(),
  public val crdSysL: List<HciCoordSystem> = emptyList()
)
