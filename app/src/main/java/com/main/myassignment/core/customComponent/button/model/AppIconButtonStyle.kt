package com.main.myassignment.core.customComponent.button.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Style configuration for AppIconButton component
 *
 * This data class consolidates all styling options for icon buttons.
 * All size values are in Int and will be converted to sdp when applied.
 *
 * @param icon Icon source - can be String (URL), Int (drawable), ImageVector, or any AppImage-supported type
 * @param contentDescription Accessibility description for the icon
 * @param tint Tint color for ImageVector icons (not applied to AppImage sources)
 * @param enabled Whether the button is enabled (affects opacity)
 * @param backgroundColor Background color of the button
 * @param iconSize Size of the icon in dp (will be converted to sdp)
 * @param padding Internal padding in dp (will be converted to sdp)
 * @param fallbackIcon Optional fallback ImageVector icon if the main icon fails to load
 */
data class AppIconButtonStyle(
    val icon: Any? = null,
    val contentDescription: String? = null,
    val tint: Color = Color.Black,
    val enabled: Boolean = true,
    val backgroundColor: Color = Color.Transparent,
    val iconSize: Int = 24,
    val padding: Int = 8,
    val fallbackIcon: ImageVector? = null
)
