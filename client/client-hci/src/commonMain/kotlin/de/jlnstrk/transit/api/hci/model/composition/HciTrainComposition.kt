package de.jlnstrk.transit.api.hci.model.composition

import de.jlnstrk.transit.api.hafas.HciModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO: Refactor as individual top level classes when there is more info
@HciModel("1.39")
@Serializable
public data class HciTrainComposition(
    public val stcDataX: Int?,
    public val stcLDir: HciStcLeavingDirection?,
    public val tcM: Int?,
    public val tcpdX: Int?,
    public val tctcX: Int?,
    public val stcGX: List<Int> = emptyList(),
    public val tcocX: List<Int> = emptyList(),
) {

    @HciModel("1.39")
    @Serializable
    public data class Attribute(
        public val c: String,
        public val n: Boolean?,
        public val T: List<T> = emptyList(),
    )

    // TODO: What is this?
    @HciModel("1.39")
    @Serializable
    public data class C(
        public val i: String?,
        public val l: Int?,
        public val n: String?,
        public val r: Boolean?,
        public val s: String?,
        public val t: String?,
        public val tcctX: Int?,
        public val A: List<Attribute> = emptyList(),
    )

    // TODO: What is this?
    @HciModel("1.39")
    @Serializable
    public data class CT(
        public val i: String,
        public val l: Int,
        public val s: String?,
        public val t: String?,
        public val A: List<Attribute> = emptyList(),
    )

    @HciModel("1.39")
    @Serializable
    public enum class Direction {
        @SerialName("A")
        ARRIVAL,

        @SerialName("D")
        DEPARTURE,
    }

    // TODO: What is this? Group?
    @HciModel("1.39")
    @Serializable
    public data class G(
        public val i: String,
        public val fc: Int?,
        public val lc: Int?,
        public val r: Boolean?,
        public val C: List<C> = emptyList(),
        public val T: List<T> = emptyList(),
    )

    // TODO: What is this?
    @HciModel("1.39")
    @Serializable
    public data class GR(
        public val g: String,
        public val tcgx: Int,
        public val r: Boolean?,
    )

    // TODO: What is this?
    @HciModel("1.39")
    @Serializable
    public data class OC(
        /** Travel class */
        public val c: String,

        /** Load rate */
        public val r: Int?
    )

    // TODO: What is this?
    @HciModel("1.39")
    @Serializable
    public data class PD(
        public val d: Direction?,
        public val i: String?,
        public val s: Int?,
        public val x: Int?,
        public val b: Boolean?,
        public val PS: List<PS> = emptyList(),
    )

    @HciModel("1.39")
    @Serializable
    public enum class Priority {
        // TODO: Meaning?
        G,

        // TODO: Meaning?
        I,

        // TODO: Meaning?
        N,

        // TODO: Meaning?
        T
    }

    // TODO: What is this?
    @HciModel("1.39")
    @Serializable
    public data class PS(
        public val e: Int?,
        public val n: String?,
        public val s: Int?,
    )

    // TODO: What is this?
    @HciModel("1.39")
    @Serializable
    public data class T(
        public val a: String?,
        public val l: String?,
        public val n: String?,
        public val p: Priority?,
        public val s: String?,
    )

    // TODO: What is this?
    @HciModel("1.39")
    @Serializable
    public data class TC(
        public val d: Direction?,
        public val r: Boolean?,
        public val v: Validity?,
        public val GR: List<GR> = emptyList(),
        public val T: List<T> = emptyList(),
    )

    @HciModel("1.39")
    @Serializable
    public enum class Validity {
        // TODO: Meaning? After?
        A,

        // TODO: Meaning? Before?
        B,

        // TODO: Meaning? During?
        D
    }
}