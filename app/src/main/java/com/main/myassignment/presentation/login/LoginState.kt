package com.main.myassignment.presentation.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isValid: Boolean = false
)
