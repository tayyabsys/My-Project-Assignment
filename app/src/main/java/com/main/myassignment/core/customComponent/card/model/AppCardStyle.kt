package com.main.myassignment.core.customComponent.card.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.main.myassignment.presentation.theme.color.WhiteColor

/**
 * Style configuration for AppCard component
 *
 * @param backgroundColor Background color of the card
 * @param shape Shape of the card corners
 * @param elevation Elevation/shadow of the card
 */
data class AppCardStyle(
    val backgroundColor: Color = WhiteColor,
    val shape: Shape = RoundedCornerShape(12.dp),
    val borderWidth: Dp = 1.dp,
    val borderColor: Color = Color.Transparent,
    val elevation: Dp = 4.dp
)
