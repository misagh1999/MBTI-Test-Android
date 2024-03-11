package app.misaghpour.mbtitestapp

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.misaghpour.mbtitestapp.ui.screens.OnBoardingScreen
import app.misaghpour.mbtitestapp.ui.screens.PreStartScreen
import app.misaghpour.mbtitestapp.ui.screens.questions.QuestionsScreen
import app.misaghpour.mbtitestapp.ui.screens.result.ResultScreen

enum class AppScreen(@StringRes val title: Int) {
    OnBoarding(title = R.string.onboarding),
    PreStart(title = R.string.pre_start),
    Questions(title = R.string.questions),
    Result(title = R.string.result)
}

@Composable
fun MBTIApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.OnBoarding.name
    ) {
        composable(route = AppScreen.OnBoarding.name) {
            OnBoardingScreen(onNextBtnClicked = {
                navController.navigate(AppScreen.PreStart.name)
            })
        }
        composable(route = AppScreen.PreStart.name) {
            PreStartScreen(onStartBtnClicked = {
                navController.navigate(AppScreen.Questions.name)
            })
        }
        composable(route = AppScreen.Questions.name) {
            QuestionsScreen(onFinishedTest = { type ->
                navController.navigate("${AppScreen.Result.name}/$type")
            })
        }
        composable(
            route = "${AppScreen.Result.name}/{type}",
            arguments = listOf(navArgument("type") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type")
            ResultScreen()
        }
    }
}