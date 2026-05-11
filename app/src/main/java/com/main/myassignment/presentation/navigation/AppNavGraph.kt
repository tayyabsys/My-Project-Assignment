package com.main.myassignment.presentation.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.*
import com.main.myassignment.presentation.home.HomeScreen
import com.main.myassignment.presentation.login.LoginScreen
import com.main.myassignment.presentation.login.LoginViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppNavGraph(startDestination: String) {
    val nav = rememberNavController()
    val loginViewModel = hiltViewModel<LoginViewModel>()
    NavHost(
        navController = nav,
        startDestination = startDestination
    ) {

        composable("login") {
            LoginScreen(loginViewModel, onLoginSuccess = {
                nav.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }

            })
        }
        composable("home") {
            HomeScreen(onLogout = {
                loginViewModel.logout()
                nav.navigate("login") {
                    popUpTo("home") { inclusive = true }
                }
            })
        }
    }
}
