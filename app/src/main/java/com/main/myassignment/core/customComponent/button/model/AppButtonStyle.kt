package com.main.myassignment.core.customComponent.button.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import com.main.myassignment.presentation.theme.color.LightGrayBorder
import com.main.myassignment.presentation.theme.color.MVARedColor
import com.main.myassignment.presentation.theme.color.RedButtonGradient
import com.main.myassignment.presentation.theme.color.RedButtonGradient1

/**
 * Style configuration for GenericButton component
 *
 * This data class consolidates all styling options for buttons, eliminating
 * the need for separate button style classes.
 *
 * @param cornerRadius Corner radius in dp (sdp will be applied)
 * @param leadingIcon Optional icon displayed before the text
 * @param trailingIcon Optional icon displayed after the text
 * @param leadingIconSize Size of the leading icon in dp (sdp will be applied)
 * @param trailingIconSize Size of the trailing icon in dp (sdp will be applied)
 * @param iconTint Tint color for icons
 * @param borderColor Border color for outlined variant
 * @param borderWidth Border width in dp
 * @param enabled Whether the button is enabled
 * @param backgroundColor Background color (used for outlined/text variants)
 * @param verticalContentPadding Vertical padding in dp (sdp will be applied)
 * @param horizontalContentPadding Horizontal padding in dp (sdp will be applied)
 * @param gradientEnabledColors Gradient colors for enabled filled variant
 * @param gradientDisabledColors Gradient colors for disabled filled variant
 */
data class AppButtonStyle(
    val cornerRadius: Int = 30,
    val leadingIcon: Painter? = null,
    val trailingIcon: Painter? = null,
    val leadingIconSize: Int = 20,
    val trailingIconSize: Int = 20,
    val iconTint: Color = MVARedColor,
    val borderColor: Color = MVARedColor,
    val borderWidth: Int = 1,
    val enabled: Boolean = true,
    val backgroundColor: Color? = null,
    val verticalContentPadding: Int = 0,
    val horizontalContentPadding: Int = 0,
    val gradientEnabledColors: List<Color> = listOf(RedButtonGradient, RedButtonGradient1),
    val gradientDisabledColors: List<Color> = listOf(LightGrayBorder, LightGrayBorder),
    val textStyle: TextStyle? = null
)
