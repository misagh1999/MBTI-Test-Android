package app.misaghpour.mbtitestapp.ui.screens.questions


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import app.misaghpour.mbtitestapp.model.Personality
import app.misaghpour.mbtitestapp.model.Question
import app.misaghpour.mbtitestapp.util.readJsonFromAssets

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json

class TestViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application.applicationContext

    private val _uiState = MutableStateFlow(TestUiState())
    val uiState: StateFlow<TestUiState> = _uiState.asStateFlow()

    lateinit var questions: List<Question>

    private var questionIndex = 0

    init {
        loadJsonFile()
        updateUiState()
    }

    fun nextQuestion() {
        if (_uiState.value.isNextBtnVisible) {
            questionIndex += 1
            updateUiState()
        }
    }

    fun previousQuestion() {
        if (_uiState.value.isPreviousBtnVisible) {
            questionIndex -= 1
            updateUiState()
        }
    }

    fun selectOption(index: Int) {
        questions[questionIndex].selectedOptionIndex = index
        updateUiState()
        if (questionIndex == questions.size - 1)
            calculateAndGoToResultScreen()
        else
            nextQuestion()
    }

    private fun updateUiState() {
        val question = questions[questionIndex]

        _uiState.update { currentState ->
            currentState.copy(
                currentIndex = questionIndex,
                optionText1 = question.option1,
                optionText2 = question.option2,
                isPreviousBtnVisible = questionIndex > 0,
                isNextBtnVisible = canNextBtn(),
                selectedOptionIndex = question.selectedOptionIndex
            )
        }
    }

    private fun canNextBtn(): Boolean {
        return if (questionIndex < questions.size - 1) {
            questions[questionIndex].selectedOptionIndex != 0
        } else {
            false
        }
    }

    private fun loadJsonFile() {
        val jsonString = readJsonFromAssets(context, "questions.json")

        val questionList: List<Question> = try {
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            emptyList()
        }

        questions = questionList
    }

    fun navigateToResultDone(){
        _uiState.update { currentState->
            currentState.copy(
                characterType = ""
            )
        }
    }

    private fun calculateAndGoToResultScreen() {
        var resultTypeStr = ""
        for (question in questions) {
            var type = ""
            val selectedOptionIndex = question.selectedOptionIndex
            if (selectedOptionIndex == 1)
                type = question.type1
            else if (selectedOptionIndex == 2)
                type = question.type2
            resultTypeStr += type
        }

        val personality = Personality.createFromCode(resultTypeStr)

        _uiState.update { currentState ->
            currentState.copy(characterType = personality.type)
        }

        // TODO: go to result screen
    }

}