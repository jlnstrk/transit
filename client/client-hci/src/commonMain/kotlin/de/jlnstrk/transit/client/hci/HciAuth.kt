package de.jlnstrk.transit.client.hci

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@JsonClassDiscriminator("type")
public sealed class HciAuth {

    @Serializable
    @SerialName("AID")
    public class AccessId(
        public val aid: String
    ) : HciAuth()

    @Serializable
    @SerialName("CIP")
    public class Cip(
        public val mic: String,
        public val mac: String
    )

    @Serializable
    @SerialName("HASH")
    public class Hash(
        public val hash: String
    )

    @Serializable
    @SerialName("USER")
    public class User(
        public val user: String,
        public val pw: String
    )
}