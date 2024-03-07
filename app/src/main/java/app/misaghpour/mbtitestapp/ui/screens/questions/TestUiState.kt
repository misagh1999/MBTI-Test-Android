package app.misaghpour.mbtitestapp.ui.screens.questions

data class TestUiState(
    val currentIndex: Int = 0,
    val optionText1: String = "Option 1",
    val optionText2: String = "Option 2",
    val selectedOptionIndex: Int = 0,
    val isNextBtnVisible: Boolean = false,
    val isPreviousBtnVisible: Boolean = false
)