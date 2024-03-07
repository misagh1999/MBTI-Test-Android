package app.misaghpour.mbtitestapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun PreStartScreen(
    modifier: Modifier = Modifier,
    onStartBtnClicked: () -> Unit) {
    Box(
        modifier = Modifier.background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Purple80,
                    Purple40,
                )
            )
        )
    ) {
        Column {
            Surface(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 28.dp,
                    bottomEnd = 28.dp
                ),
                modifier = Modifier.weight(5f)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("MBTI TEST", fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(R.drawable.temp_logo),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Image(
                        painter = painterResource(R.drawable.pre_start_img),
                        contentDescription = null,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            "Easy Test, Lovely",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 36.sp,
                            textAlign = TextAlign.Start
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(0.5f))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.weight(4f),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Yellow
                    ),
                    onClick = onStartBtnClicked) {
                    Text(
                        stringResource(R.string.start_test),
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.weight(0.5f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreStartScreenPreview() {
    MBTITestAppTheme {
        PreStartScreen(onStartBtnClicked = {})
    }
}