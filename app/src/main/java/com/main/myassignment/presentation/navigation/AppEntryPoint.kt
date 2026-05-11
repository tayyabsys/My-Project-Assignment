package com.main.myassignment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.main.myassignment.core.util.SecureStorageManager
import com.main.myassignment.presentation.login.LoginViewModel

@Composable
fun AppEntryPoint(loginViewModel: LoginViewModel = hiltViewModel()) {
    val isLoggedIn by loginViewModel.isLoggedIn.collectAsState()

    when (isLoggedIn) {
        false-> {
            // optional loading UI
            AppNavGraph(startDestination = "login",loginViewModel)
        }

        true -> {
            AppNavGraph(startDestination = "home")
        }


        else -> {}
    }
}