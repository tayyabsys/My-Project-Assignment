package com.main.myassignment.core.customComponent.text.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.main.myassignment.presentation.theme.color.LightAppExtendedColor

data class AppTextFieldStyle(
    val cornerRadius: Int = 28,
    val textStyle: TextStyle? = null,
    val placeholderText: String = "",
    val placeholderColor: Color = LightAppExtendedColor.contentTertiary,
    val focusedBorderColor: Color = LightAppExtendedColor.borderFocus,
    val unfocusedBorderColor: Color = LightAppExtendedColor.borderTertiary,
    val errorBorderColor: Color = LightAppExtendedColor.borderNegative,
    val cursorColor: Color = LightAppExtendedColor.contentBrand,
    val backgroundColor: Color = LightAppExtendedColor.backgroundPrimary,
    val verticalPadding: Int = 15,
    val horizontalPadding: Int = 16,
    val leadingIconSource: Any? = null,
    val trailingIconSource: Any? = null,
    val leadingIconSize: Int = 24,
    val leadingIconWidth: Int? = null,
    val leadingIconHeight: Int? = null,
    val leadingIconTint: Color = Color.Unspecified,
    val trailingIconSize: Int = 16,
    val trailingIconWidth: Int? = null,
    val trailingIconHeight: Int? = null,
    val trailingIconTint: Color = Color.Unspecified,
    val trailingIconBackgroundColor: Color? = null,
    val trailingIconBackgroundSize: Int = 32,
    val enabled: Boolean = true,
    val readOnly: Boolean = false,
    val singleLine: Boolean = true,
    val maxLines: Int = 1,
    val isError: Boolean = false
)
