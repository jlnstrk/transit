package de.jlnstrk.transit.util.response

import de.jlnstrk.transit.util.model.Message
import de.jlnstrk.transit.util.response.base.ServiceResult

public class StatusInformationData(
    public val messages: List<Message>
) : ServiceResult.Data