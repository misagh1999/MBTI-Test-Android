package app.misaghpour.mbtitestapp

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.misaghpour.mbtitestapp.ui.screens.OnBoardingScreen
import app.misaghpour.mbtitestapp.ui.screens.PreStartScreen
import app.misaghpour.mbtitestapp.ui.screens.QuestionsScreen

enum class AppScreen(@StringRes val title: Int) {
    OnBoarding(title = R.string.onboarding),
    PreStart(title = R.string.pre_start),
    Questions(title = R.string.questions)
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
                navController.navigate(AppScreen.PreStart.name)
            })
        }
        composable(route = AppScreen.PreStart.name){
            PreStartScreen(onStartBtnClicked = {
                navController.navigate(AppScreen.Questions.name)
            })
        }
        composable(route = AppScreen.Questions.name) {
            QuestionsScreen()
        }
    }
}