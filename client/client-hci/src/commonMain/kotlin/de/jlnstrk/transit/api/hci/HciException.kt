package de.jlnstrk.transit.api.hci

import de.jlnstrk.transit.api.hci.response.HciError
import de.jlnstrk.transit.api.hci.response.HciServiceError

public sealed class HciException(
    message: String?,
    public val displayMessage: String?,
    cause: Throwable?,
) : RuntimeException(message, cause) {

    public class General(
        public val error: HciError,
        message: String? = null,
        displayMessage: String? = null,
        cause: Throwable? = null,
    ) : HciException(message, displayMessage, cause) {
        override fun toString(): String {
            return "HciException.General(error=$error, message=$message, displayMessage=$displayMessage)"
        }
    }

    public class Service(
        public val serviceError: HciServiceError,
        message: String? = null,
        displayMessage: String? = null,
        cause: Throwable? = null,
    ) : HciException(message, displayMessage, cause) {
        override fun toString(): String {
            return "HciException.Service(serviceError=$serviceError, message=$message, displayMessage=$displayMessage)"
        }
    }

    public class Other(
        message: String? = null,
        displayMessage: String? = null,
        cause: Throwable? = null,
    ) : HciException(message, displayMessage, cause) {
        override fun toString(): String {
            return "HciException.General(message=$message, displayMessage=$displayMessage)"
        }
    }
}