package com.main.myassignment.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.main.myassignment.presentation.theme.type.AppTypography
import com.main.myassignment.presentation.theme.color.DarkAppExtendedColor
import com.main.myassignment.presentation.theme.color.LightAppExtendedColor
import com.main.myassignment.presentation.theme.color.LocalAppExtendedColor

/**
 * AppTheme composable that provides theming support for the application.
 * Automatically detects system dark mode and applies appropriate colors.
 *
 * @param darkTheme Whether to use dark theme. Defaults to system setting.
 * @param content The composable content to be themed
 */
@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val extendedColors = if (darkTheme) DarkAppExtendedColor else LightAppExtendedColor
    
    CompositionLocalProvider(
        LocalAppExtendedColor provides extendedColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}
