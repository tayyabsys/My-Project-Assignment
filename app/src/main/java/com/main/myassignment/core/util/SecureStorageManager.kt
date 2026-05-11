package com.main.myassignment.core.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SecureStorageManager @Inject constructor(
    @ApplicationContext private val context: Context
) {

    companion object {
        private val tag = SecureStorageManager::class.simpleName.toString()

        // Default Values
        private const val DEFAULT_VALUE_BOOLEAN: Boolean = false

        // Keys
        private const val KEY_SAVE_LOGIN = "save_login"

        // 48 hours in milliseconds
        private const val SNOOZE_DURATION_MS = 48L * 60 * 60 * 1000 // 48 hours
    }

    /**
     * Store Login session
     */
    fun saveLogin(isLogin: Boolean) {
        SecureStorage.setValue(context, KEY_SAVE_LOGIN, isLogin)
    }

    /**
     * Get Login session
     */
    fun getLoginSession(): Boolean {
        return SecureStorage.getValue(context, KEY_SAVE_LOGIN, false)
    }


    /**
     * Clear all secure storage
     */
    fun clearAll() {
        SecureStorage.clearAllKeychain(context)
    }

}
