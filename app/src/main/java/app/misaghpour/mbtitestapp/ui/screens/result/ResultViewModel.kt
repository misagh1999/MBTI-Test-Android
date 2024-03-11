package app.misaghpour.mbtitestapp.ui.screens.result

import android.content.Context
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import app.misaghpour.mbtitestapp.R
import app.misaghpour.mbtitestapp.model.Result
import app.misaghpour.mbtitestapp.util.readJsonFromAssets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json

class ResultViewModel(
    savedStateHandle: SavedStateHandle,
    private val context: Context) : ViewModel() {

    private val characterType: String = checkNotNull(savedStateHandle["type"])

    private val _uiState = MutableStateFlow(ResultUiState())
    val uiState: StateFlow<ResultUiState> = _uiState.asStateFlow()

    private lateinit var result: Result

    private var _index = 0

    init {
        loadJsonFile()
    }

    fun nextSection() {
        if (_index < MAX_SECTIONS_SIZE - 1) {
            _index += 1
            updateUiState()
        }
    }

    fun previousSection() {
        if (_index > 0) {
            _index -= 1
            updateUiState()
        }
    }

    private fun updateUiState() {
        var title = ""
        var text = ""
        var image = context.resources.getIdentifier(
            result.type.lowercase(),
            "drawable",
            context.packageName
        )
        when (_index) {
            0 -> {
                title = MAIN
            }

            1 -> {
                // Description Section
                title = DESCRIPTION
                text = result.desc
            }

            2 -> {
                // Work Section
                title = WORK
                text = result.work
                image = R.drawable.work_pic
            }

            3 -> {
                // Relationship
                title = RELATIONSHIP
                text = result.relationship
                image = R.drawable.relationship_pic
            }

            4 -> {
                // Hobby
                title = HOBBY
                text = result.hobby
                image = R.drawable.hobby_pic
            }

            5 -> {
                // Suggestions
                title = SUGGESTION
            }
        }
        _uiState.update { currentSate ->
            currentSate.copy(
                characterType = result.type,
                characterTitle = result.title,
                title = title,
                text = text,
                favoriteSentence = result.favoriteSentence,
                suggestions = result.suggestions,
                image = image
            )
        }

        updateBottomButtons()
    }

    private fun updateBottomButtons() {
        var nextTitle = ""
        var previousTitle = ""
        when (_index) {
            0 -> { // MAIN
                nextTitle = DESCRIPTION
            }

            1 -> { // Description
                nextTitle = WORK
                previousTitle = MAIN
            }

            2 -> { // Work
                nextTitle = RELATIONSHIP
                previousTitle = DESCRIPTION
            }

            3 -> { // Relationship
                nextTitle = HOBBY
                previousTitle = WORK
            }

            4 -> { // Hobby
                nextTitle = SUGGESTION
                previousTitle = RELATIONSHIP
            }

            5 -> { // Suggestion
                previousTitle = HOBBY
            }

        }
        _uiState.update { currentState ->
            currentState.copy(
                nextSectionTitle = nextTitle,
                previousSectionTitle = previousTitle
            )
        }
    }

    private fun loadJsonFile() {
        val characterType = this.characterType
        Log.d("FINAL_TYPE", characterType)
        val jsonString = readJsonFromAssets(context, "$characterType.json")

        val result: Result = try {
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            Log.e("READ_JSON", e.message.toString())
            Result()
        }

        this.result = result

        updateUiState()
    }

    companion object {
        const val MAX_SECTIONS_SIZE = 6
        const val MAIN = "Main"
        const val DESCRIPTION = "Description"
        const val WORK = "Work"
        const val RELATIONSHIP = "Relationship"
        const val HOBBY = "Hobby"
        const val SUGGESTION = "Suggestions"
    }
}