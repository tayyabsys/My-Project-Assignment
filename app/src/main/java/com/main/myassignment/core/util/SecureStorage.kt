@file:Suppress("UNCHECKED_CAST")

package com.main.myassignment.core.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import androidx.core.content.edit

object SecureStorage {
    private const val SECURE_PREFS_FILE = "secure_prefs"
    private const val TAG = "SecureStorage"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        return try {
            EncryptedSharedPreferences.create(
                context,
                SECURE_PREFS_FILE,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        } catch (e: Exception) {
            // If keyset decryption fails (e.g. app restore/reinstall), reset encrypted prefs and recreate.
            Log.w(TAG, "Encrypted prefs init failed, resetting secure prefs", e)
            context.deleteSharedPreferences(SECURE_PREFS_FILE)
            EncryptedSharedPreferences.create(
                context,
                SECURE_PREFS_FILE,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        }
    }

    // Generic method to save data
    fun <T> setValue(context: Context, key: String, value: T) {
        getSharedPreferences(context).edit {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                else -> throw IllegalArgumentException("Unsupported data type")
            }
        }
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
        getSharedPreferences(context).edit { clear() }
    }
}
