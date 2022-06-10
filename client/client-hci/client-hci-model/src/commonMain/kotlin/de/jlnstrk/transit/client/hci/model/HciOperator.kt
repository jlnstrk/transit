package de.jlnstrk.transit.client.hci.model

import de.jlnstrk.transit.client.hafas.HciModel
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@HciModel("1.45")
@Serializable
public data class HciOperator(
  public val addName: String? = null,
  public val email: String? = null,
  public val fax: String? = null,
  public val icoX: Int? = null,
  public val id: String? = null,
  public val name: String,
  public val nameL: String? = null,
  public val nameN: String? = null,
  public val nameS: String? = null,
  public val phone: String? = null,
  public val street: String? = null,
  public val town: String? = null,
  public val url: String? = null,
  public val adminL: List<String> = emptyList(),
  public val pRefL: List<Int> = emptyList(),
  public val _default: Boolean = false,
)
