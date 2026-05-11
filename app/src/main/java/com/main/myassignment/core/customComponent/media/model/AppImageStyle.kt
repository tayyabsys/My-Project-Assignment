package com.main.myassignment.core.customComponent.media.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale

/**
 * Centralized style configuration for AppImage component.
 * Specify shape, corner radius, background, content scale, size, etc.
 * Example usage: style = AppImageStyle(width = 80.dp, cornerRadius = 12.dp)
 *
 * @param width Desired image width in dp (optional)
 * @param height Desired image height in dp (optional)
 * @param cornerRadius Corner radius for rounded image shape, in dp (default 0.dp).
 * @param shape Optional custom shape (overrides cornerRadius if set)
 * @param contentScale How image is scaled inside bounds (default Fit).
 * @param backgroundColor Color to paint behind image (default Transparent)
 * @param placeholder Compose resource for image placeholder
 * @param error Compose resource for error fallback
 * @param clip True if image should be clipped to shape/corner radius
 */
data class AppImageStyle(
    val width: Int = 24,
    val height: Int = 24,
    val cornerRadius: Int = 4,
    val shape: Shape? = null,
    val contentScale: ContentScale = ContentScale.Fit,
    val backgroundColor: Color = Color.Unspecified,
    val tintColor: Color = Color.Unspecified,
    @DrawableRes val placeholder: Int? = null,
    @DrawableRes val error: Int? = null,
    val clip: Boolean = false
)
