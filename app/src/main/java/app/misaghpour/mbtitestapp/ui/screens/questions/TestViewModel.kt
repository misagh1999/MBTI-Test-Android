package app.misaghpour.mbtitestapp.ui.screens.questions

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TestViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TestUiState())
    val uiState: StateFlow<TestUiState> = _uiState.asStateFlow()

    init {

    }

    fun nextQuestion() {
        // TODO: next question
    }

    fun previousQuestion() {
        // TODO: previous question
    }

    fun selectOption(index: Int) {

    }

}