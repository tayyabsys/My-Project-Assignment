package com.main.myassignment.presentation.login

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.myassignment.core.base.BaseViewModel
import com.main.myassignment.core.util.SecureStorageManager
import com.main.myassignment.core.util.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(private val secureStorageManager: SecureStorageManager,
) : BaseViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    val isValid: Boolean
        get() = email.isValidEmail() && password.length in 8..15

    fun login() = viewModelScope.launch {
        secureStorageManager.saveLogin(true)
    }
    fun logout() = viewModelScope.launch {
        secureStorageManager.saveLogin(false)
    }
}
