package de.jlnstrk.transit.common.response

import de.jlnstrk.transit.common.model.DataHeader
import de.jlnstrk.transit.common.model.Message
import de.jlnstrk.transit.common.response.base.ScrollContext
import de.jlnstrk.transit.common.response.base.ScrollableData
import de.jlnstrk.transit.common.response.base.ServiceResult

public data class MessageListData(
    override val header: DataHeader,
    public val messages: List<Message>,
    override val scrollContext: ScrollContext<MessageListData>?
) : ServiceResult.Data, ScrollableData<MessageListData>