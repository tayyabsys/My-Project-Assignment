package com.main.myassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.main.myassignment.core.util.SecureStorageManager
import com.main.myassignment.presentation.navigation.AppEntryPoint
import dagger.hilt.android.AndroidEntryPoint
import com.main.myassignment.presentation.navigation.AppNavGraph
import qa.vodafone.myvodafone.revamp.core.ui.theme.AppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var secureStorageManager: SecureStorageManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppEntryPoint(secureStorageManager)
            }
        }
    }
}

