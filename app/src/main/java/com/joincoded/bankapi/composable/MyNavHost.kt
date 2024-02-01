package com.joincoded.bankapi.composable

import SignInScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.utils.Routes
import com.joincoded.bankapi.viewmodel.BankViewModel

@Composable
fun MyNavHost() {
    val navController = rememberNavController()
    val viewmodel: BankViewModel = viewModel()


    if (viewmodel.token?.token != null) {
        navController.navigate(Routes.transactionRoute)

    }




    NavHost(navController = navController, startDestination = Routes.homeRoute) {
        composable(Routes.homeRoute) {
            HomePageScreen(
                viewmodel,
                onSignInClicked = { navController.navigate(Routes.singInRoute) },
                onSignUpClicked = { navController.navigate(Routes.signupRoute) }
            )
        }
        composable(Routes.singInRoute) {
            SignInScreen(viewmodel)
        }
        composable(Routes.signupRoute) {
            SignUpComposable(viewmodel,
                onSignInClicked = { navController.navigate(Routes.singInRoute) },
                onSignUpClicked = { navController.navigate(Routes.signupRoute) }
            )
        }

        composable(Routes.transactionRoute) {
            TransactionsScreen(viewmodel)
        }
    }
}
