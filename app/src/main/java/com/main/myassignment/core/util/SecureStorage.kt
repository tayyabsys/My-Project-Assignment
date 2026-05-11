package com.main.myassignment.core.util

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object SecureStorage {


    private fun getSharedPreferences(context: Context): EncryptedSharedPreferences {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        return EncryptedSharedPreferences.create(
            context,
            "secure_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        ) as EncryptedSharedPreferences
    }

    // Generic method to save data
    fun <T> setValue(context: Context, key: String, value: T) {
        val prefs = getSharedPreferences(context).edit()
        when (value) {
            is String -> prefs.putString(key, value)
            is Int -> prefs.putInt(key, value)
            is Boolean -> prefs.putBoolean(key, value)
            is Float -> prefs.putFloat(key, value)
            is Long -> prefs.putLong(key, value)
            else -> throw IllegalArgumentException("Unsupported data type")
        }
        prefs.apply()
    }

    // Generic method to retrieve data
    fun <T> getValue(context: Context, key: String, defaultValue: T): T {
        val prefs = getSharedPreferences(context)
        return when (defaultValue) {
            is String -> prefs.getString(key, defaultValue) as T
            is Int -> prefs.getInt(key, defaultValue) as T
            is Boolean -> prefs.getBoolean(key, defaultValue) as T
            is Float -> prefs.getFloat(key, defaultValue) as T
            is Long -> prefs.getLong(key, defaultValue) as T
            else -> throw IllegalArgumentException("Unsupported data type")
        }
    }

    // Clear all stored values securely
    fun clearAllKeychain(context: Context) {
        getSharedPreferences(context).edit().clear().apply()
    }
}
