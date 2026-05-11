package com.main.myassignment.presentation.navigation

import androidx.compose.runtime.Composable
import com.main.myassignment.core.util.SecureStorageManager

@Composable
fun AppEntryPoint(secureStorageManager: SecureStorageManager) {

    val isLoggedIn = secureStorageManager.getLoginSession()
    when (isLoggedIn) {

        null , false-> {
            // optional loading UI
            AppNavGraph(startDestination = "login")
        }

        true -> {
            AppNavGraph(startDestination = "home")
        }


    }
}