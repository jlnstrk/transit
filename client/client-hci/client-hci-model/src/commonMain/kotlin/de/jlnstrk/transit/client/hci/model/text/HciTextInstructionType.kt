package de.jlnstrk.transit.client.hci.model.text

import de.jlnstrk.transit.client.hafas.HciModel
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public enum class HciTextInstructionType {
  BOLD,
  CALL,
  ITALIC,
  LINK,
  NONE,
  PROD,
  WEBVIEW,
}
