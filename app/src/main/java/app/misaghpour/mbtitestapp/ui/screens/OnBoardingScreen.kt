package app.misaghpour.mbtitestapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.misaghpour.mbtitestapp.R
import app.misaghpour.mbtitestapp.ui.theme.MBTITestAppTheme
import app.misaghpour.mbtitestapp.ui.theme.Purple40
import app.misaghpour.mbtitestapp.ui.theme.Purple80

@Composable
fun OnBoardingScreen(
    onNextBtnClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(0.5f))
        Image(
            painter = painterResource(R.drawable.temp_logo),
            contentDescription = null,
            modifier.size(56.dp)
        )
        Spacer(modifier = Modifier.weight(0.5f))
        Text(
            "Welcome to",
            fontWeight = FontWeight.Bold,
        )
        Row {
            Text(
                "MBTI Test ",
                color = Purple80
            )
            Text(
                "App",

                )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            "An app you can find your personality type",
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Image(
            painter = painterResource(R.drawable.main_splash),
            contentDescription = null,
            modifier = Modifier.padding(24.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Purple40
            ),
            onClick = onNextBtnClicked,
        ) {
            Text(
                "Get Started",
                fontSize = 17.sp,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))

    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    MBTITestAppTheme {
        OnBoardingScreen(onNextBtnClicked = {})
    }
}