package app.misaghpour.mbtitestapp.ui.screens.questions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import app.misaghpour.mbtitestapp.R
import app.misaghpour.mbtitestapp.ui.theme.MBTITestAppTheme

@Composable
fun QuestionsScreen(
    testViewModel: TestViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    val testUiState by testViewModel.uiState.collectAsState()

    Column(modifier = modifier.padding(36.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = null,
                modifier = Modifier.clickable {
                    testViewModel.previousQuestion()
                })
            Spacer(modifier = Modifier.weight(0.5f))
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFFE4E4E4),
                modifier = Modifier
                    .height(10.dp)
                    .weight(2f)
            ) {
                Surface(modifier = Modifier.width(45.dp)) {

                }
            }
            Spacer(modifier = Modifier.weight(0.5f))

            Image(
                painter = painterResource(R.drawable.arrow_right),
                contentDescription = null,
                modifier = Modifier.clickable {
                    testViewModel.nextQuestion()
                })

        }
        Text("Question ${testUiState.currentIndex + 1}/60")
        Spacer(modifier = Modifier.weight(1f))
        Column {
            QuestionItem(
                text = testUiState.optionText1,
                isHighlighted = false,
                onClicked = {
                    testViewModel.selectOption(1)
                })
            Spacer(modifier = Modifier.height(16.dp))
            QuestionItem(
                text = testUiState.optionText2,
                isHighlighted = false,
                onClicked = {
                    testViewModel.selectOption(2)
                })
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun QuestionItem(text: String, onClicked: () -> Unit, isHighlighted: Boolean = false) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = if (isHighlighted) Color(0xFF3F51B5) else Color(0xFFEEEEEE),
        contentColor = if (isHighlighted) Color(0xFFFFFFFF) else Color(0xFF272727),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClicked()
            }
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionsScreenPreview() {
    MBTITestAppTheme {
        QuestionsScreen()
    }
}