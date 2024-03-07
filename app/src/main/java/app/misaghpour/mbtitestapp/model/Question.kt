package app.misaghpour.mbtitestapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Question (
    val index: Int,
    val option1: String,
    val option2: String,
    val type1: String,
    val type2: String,
    var selectedOptionIndex: Int = 0
)