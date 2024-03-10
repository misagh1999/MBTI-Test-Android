package app.misaghpour.mbtitestapp.ui.screens.result

data class ResultUiState(
    val characterType: String = "",
    val characterTitle: String = "",
    val title: String = "",
    val text: String = "",
    val favoriteSentence: String = "",
    val nextSectionTitle: String = "",
    val previousSectionTitle: String = "",
    val image: Int = 0,
    val suggestions: List<String> = listOf()
)