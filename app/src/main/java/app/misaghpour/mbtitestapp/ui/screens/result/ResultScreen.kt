package app.misaghpour.mbtitestapp.ui.screens.result


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import app.misaghpour.mbtitestapp.R
import app.misaghpour.mbtitestapp.ui.AppViewModelProvider
import app.misaghpour.mbtitestapp.ui.theme.MBTITestAppTheme

@Composable
fun ResultScreen(
    viewModel: ResultViewModel = viewModel(factory = AppViewModelProvider.Factory),
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .padding(36.dp)
            .fillMaxSize()
    ) {
        val bodyModifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())

        TopBar()
        Spacer(modifier = Modifier.height(12.dp))
        if (uiState.title == ResultViewModel.MAIN) {
            ResultMain(
                characterType = uiState.characterType,
                characterTitle = uiState.characterTitle,
                favoriteSentence = uiState.favoriteSentence,
                image = uiState.image,
                modifier = bodyModifier
            )
        } else if (uiState.title == ResultViewModel.SUGGESTION) {
            ResultSuggestions(
                suggestions = uiState.suggestions,
                modifier = bodyModifier
            )
        } else {
            ResultDescription(
                title = uiState.title,
                characterType = uiState.characterType,
                description = uiState.text,
                image = uiState.image,
                modifier = bodyModifier
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        BottomBarButtons(
            modifier = modifier,
            nextTitle = uiState.nextSectionTitle,
            previousTitle = uiState.previousSectionTitle,
            onPreviousClicked = viewModel::previousSection,
            onNextClicked = viewModel::nextSection
        )
    }
}

@Composable
fun TopBar() {
    Row {
        Image(
            painter = painterResource(R.drawable.back_icon),
            contentDescription = null,
            modifier = Modifier.clickable {
                // TODO: implement back btn
            })
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Your Result")
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ResultMain(
    characterType: String,
    characterTitle: String,
    favoriteSentence: String,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Column(modifier = Modifier.weight(1f)) {
                Text("Your Personality Type")
                Text(
                    characterType,
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                )
                Text(characterTitle)
            }
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.weight(0.6f)
            )
        }
        Text(text = "Favorite Sentence")
        Text(
            text = favoriteSentence,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ResultDescription(
    title: String,
    characterType: String,
    description: String,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(title, style = TextStyle(fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.weight(1f))
            Text(characterType, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = description, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.align(alignment = Alignment.End)
        )
    }
}

@Composable
fun ResultSuggestions(
    suggestions: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Result suggestions",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(16.dp))
        for (suggestion in suggestions) {
            Text(text = "* $suggestion", modifier = Modifier.padding(bottom = 12.dp))
        }
    }
}

@Composable
fun BottomBarButtons(
    onPreviousClicked: () -> Unit,
    onNextClicked: () -> Unit,
    previousTitle: String,
    nextTitle: String,
    modifier: Modifier = Modifier
) {
    Row {
        if (previousTitle.isNotEmpty())
            Button(onClick = onPreviousClicked, modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.arrow_left),
                        modifier = modifier.size(12.dp),
                        colorFilter = ColorFilter.tint(color = Color(0xFFFFFFFF)),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = previousTitle)
                }
            }
        else Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(16.dp))
        if (nextTitle.isNotEmpty())
            Button(onClick = onNextClicked, modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = nextTitle)
                    Spacer(modifier = Modifier.width(4.dp))
                    Image(
                        painter = painterResource(R.drawable.arrow_right),
                        modifier = modifier.size(12.dp),
                        colorFilter = ColorFilter.tint(color = Color(0xFFFFFFFF)),
                        contentDescription = null
                    )
                }
            }
        else Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultScreenPreview() {
    MBTITestAppTheme {
        ResultScreen()
    }
}