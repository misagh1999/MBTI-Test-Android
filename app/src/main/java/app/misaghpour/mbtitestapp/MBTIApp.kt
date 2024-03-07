package app.misaghpour.mbtitestapp

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.misaghpour.mbtitestapp.ui.screens.OnBoardingScreen

enum class AppScreen(@StringRes val title: Int) {
    OnBoarding(title = R.string.onboarding),
}

@Composable
fun MBTIApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.OnBoarding.name
    ) {
        composable(route = AppScreen.OnBoarding.name){
            OnBoardingScreen(onNextBtnClicked = {
                // TODO: implement later
            })
        }
    }
}