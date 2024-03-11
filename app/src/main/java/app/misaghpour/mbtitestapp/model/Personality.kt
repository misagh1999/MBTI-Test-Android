package app.misaghpour.mbtitestapp.model

class Personality(val code: String) {
    lateinit var type: String

    private var eValue: Int = 0
    private var iValue: Int = 0

    private var nValue: Int = 0
    private var sValue: Int = 0

    private var fValue: Int = 0
    private var tValue: Int = 0

    private var pValue: Int = 0
    private var jValue: Int = 0

    init {
        _calculateType()
    }

    companion object {
        fun createFromCode(code: String): Personality {
            return Personality(code).apply {
                _calculateType()
            }
        }
    }

    private fun _calculateType() {
        var eNum = 0
        var nNum = 0
        var fNum = 0
        var pNum = 0

        for (i in code.indices) {
            val type = code[i]
            when (type.toString()) {
                Types.E -> eNum++
                Types.N -> nNum++
                Types.F -> fNum++
                Types.P -> pNum++
            }
        }

        eValue = eNum
        iValue = 15 - eNum

        nValue = nNum
        sValue = 15 - nNum

        fValue = fNum
        tValue = 15 - fNum

        pValue = pNum
        jValue = 15 - pNum

        val result = StringBuilder()

        result.append(if (eNum > 7) Types.E else Types.I)
        result.append(if (nNum > 7) Types.N else Types.S)
        result.append(if (fNum > 7) Types.F else Types.T)
        result.append(if (pNum > 7) Types.P else Types.J)

        type = result.toString()
    }
}

class Types {
    companion object {
        const val E = "E"; // extrovert
        const val I = "I"; // introvert

        const val N = "N"; // intuitive
        const val S = "S"; // sensing

        const val F = "F"; // feeling
        const val T = "T"; // thinking

        const val P = "P"; // perceiving
        const val J = "J"; // judging
    }
}