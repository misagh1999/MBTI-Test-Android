package app.misaghpour.mbtitestapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val type: String = "",
    val title: String = "",
    @SerialName(value = "favorite_sen")
    val favoriteSentence: String = "",
    val desc: String = "",
    val work: String = "",
    val relationship: String = "",
    val hobby: String = "",
    @SerialName(value = "dark_color")
    val darkColor: String = "",
    @SerialName(value = "light_color")
    val lightColor: String = "",
    @SerialName(value = "suggestion")
    val suggestions: List<String> = listOf()
)