package com.main.myassignment.core.customComponent.text

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.myassignment.core.customComponent.media.AppImage
import com.main.myassignment.core.customComponent.media.model.AppImageStyle
import com.main.myassignment.core.customComponent.media.model.ImageIconSource
import com.main.myassignment.core.customComponent.text.model.AppTextFieldStyle
import com.main.myassignment.core.customComponent.text.model.AppTextStyle
import com.main.myassignment.core.customComponent.text.model.TextFieldVariant
import com.main.myassignment.presentation.theme.color.LocalAppExtendedColor
import com.main.myassignment.presentation.theme.dimens.sdp
import com.main.myassignment.presentation.theme.AppTheme

/**
 * A generic, reusable text field component that supports:
 * - Leading and trailing icons using AppImage (URL, drawable, etc.)
 * - Fully customizable through AppTextFieldStyle
 * - Error state handling
 * - Single/multi-line support
 * - Keyboard options and actions
 * - Outlined or Filled variants
 * - Custom internal padding via horizontalPadding and verticalPadding
 *
 * Features:
 * - Uses BasicTextField for full customization
 * - Uses AppImage for icons (supports all media types)
 * - Consistent styling with AppButtonStyle pattern
 * - Scalable dimensions (Int → .sdp at usage)
 * - Supports Outlined (with border) or Filled (no border) variants
 * - Full control over internal padding
 *
 * @param value The current text value
 * @param onValueChange Callback when text changes
 * @param modifier Modifier for the text field
 * @param style Text field style configuration
 * @param variant TextField variant (Outlined or Filled)
 * @param onTrailingIconClick Optional callback when trailing icon is clicked
 * @param keyboardOptions Keyboard options for input
 * @param keyboardActions Keyboard actions for IME
 */
@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    style: AppTextFieldStyle,
    modifier: Modifier = Modifier,
    variant: TextFieldVariant = TextFieldVariant.Outlined,
    onTrailingIconClick: (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None

) {
    // Use bodyRegular as default if textStyle is null
    val effectiveTextStyle = style.textStyle ?: AppTextStyle.bodyRegular()

    val borderColor = when {
        style.isError -> style.errorBorderColor
        else -> style.unfocusedBorderColor
    }

    val borderWidth = when (variant) {
        TextFieldVariant.Outlined -> 1.dp
        TextFieldVariant.Filled -> 0.dp
    }

    val shape = RoundedCornerShape(style.cornerRadius.sdp)

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 56.dp),
        textStyle = effectiveTextStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = style.singleLine,
        visualTransformation = visualTransformation,
        maxLines = if (style.singleLine) 1 else style.maxLines,
        enabled = style.enabled,
        readOnly = style.readOnly,
        cursorBrush = SolidColor(style.cursorColor),
        decorationBox = @Composable { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape)
                    .background(
                        color = if (style.enabled) {
                            style.backgroundColor
                        } else {
                            style.backgroundColor.copy(alpha = 0.6f)
                        },
                        shape = shape
                    )
                    .then(
                        if (borderWidth > 0.dp) {
                            Modifier.border(
                                width = borderWidth,
                                color = borderColor,
                                shape = shape
                            )
                        } else {
                            Modifier
                        }
                    )
                    .padding(
                        horizontal = style.horizontalPadding.sdp,
                        vertical = style.verticalPadding.sdp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.sdp)
            ) {
                // Leading icon
                if (style.leadingIconSource != null) {
                    TextFieldIcon(
                        source = style.leadingIconSource,
                        width = style.leadingIconWidth ?: style.leadingIconSize,
                        height = style.leadingIconHeight ?: style.leadingIconSize,
                        tint = style.leadingIconTint
                    )
                }

                // Text field content with placeholder
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value.isEmpty() && style.placeholderText.isNotEmpty()) {
                        Text(
                            text = style.placeholderText,
                            style = effectiveTextStyle,
                            color = style.placeholderColor
                        )
                    }
                    innerTextField()
                }

                // Trailing icon
                if (style.trailingIconSource != null) {
                    RenderTrailingIcon(
                        style = style,
                        onTrailingIconClick = onTrailingIconClick
                    )
                }
            }
        }
    )
}

@Composable
private fun RenderTrailingIcon(
    style: AppTextFieldStyle,
    onTrailingIconClick: (() -> Unit)?
) {
    val trailingWidth = style.trailingIconWidth ?: style.trailingIconSize
    val trailingHeight = style.trailingIconHeight ?: style.trailingIconSize

    if (style.trailingIconBackgroundColor != null) {
        // With circular background
        Box(
            modifier = Modifier.size(style.trailingIconBackgroundSize.sdp)
                .background(
                    color = style.trailingIconBackgroundColor,
                    shape = CircleShape
                )
                .clickable(
                    enabled = onTrailingIconClick != null,
                    onClick = { onTrailingIconClick?.invoke() }
                )
                .padding(8.sdp),
            contentAlignment = Alignment.Center
        ) {
            TextFieldIcon(
                source = style.trailingIconSource!!,
                width = trailingWidth,
                height = trailingHeight,
                tint = style.trailingIconTint
            )
        }
    } else {
        // Without background
        Box(
            modifier = Modifier.clickable(
                enabled = onTrailingIconClick != null,
                onClick = { onTrailingIconClick?.invoke() }
            ),
            contentAlignment = Alignment.Center
        ) {
            TextFieldIcon(
                source = style.trailingIconSource!!,
                width = trailingWidth,
                height = trailingHeight,
                tint = style.trailingIconTint
            )
        }
    }
}

@Composable
private fun TextFieldIcon(
    source: Any,
    width: Int,
    height: Int,
    tint: Color
) {
    AppImage(
        source = source,
        style = AppImageStyle(
            width = width,
            height = height,
            tintColor = tint
        ),
        modifier = Modifier.size(width = width.sdp, height = height.sdp)
    )
}

// ============================================
// Preview Functions
// ============================================

@Preview(showBackground = true, name = "Text Field with Icons")
@Composable
private fun AppTextFieldPreview() {
    AppTheme {
        val colors = LocalAppExtendedColor.current
        AppTextField(
            value = "",
            onValueChange = {},
            style = AppTextFieldStyle(
                placeholderText = "Search services...",
                placeholderColor = colors.contentSecondary,
                focusedBorderColor = colors.borderPrimary,
                unfocusedBorderColor = colors.borderTertiary,
                errorBorderColor = colors.borderNegative,
                cursorColor = colors.contentPrimary,
                backgroundColor = colors.backgroundTertiary,
                cornerRadius = 8,
                leadingIconSize = 24,
                trailingIconSize = 24,
                horizontalPadding = 16,
                verticalPadding = 12
            ),
            onTrailingIconClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Text Field Error State")
@Composable
private fun AppTextFieldErrorPreview() {
    AppTheme {
        val colors = LocalAppExtendedColor.current
        AppTextField(
            value = "Invalid input",
            onValueChange = {},
            variant = TextFieldVariant.Outlined,
            style = AppTextFieldStyle(
                placeholderText = "Enter text...",
                placeholderColor = colors.contentSecondary,
                focusedBorderColor = colors.borderPrimary,
                unfocusedBorderColor = colors.borderTertiary,
                errorBorderColor = colors.borderNegative,
                cursorColor = colors.contentPrimary,
                backgroundColor = colors.backgroundTertiary,
                isError = true
            )
        )
    }
}


@Preview(showBackground = true, name = "Text Field with Circular Icon Background")
@Composable
private fun AppTextFieldCircularIconPreview() {
    AppTheme {
        val colors = LocalAppExtendedColor.current
        AppTextField(
            value = "Search query",
            onValueChange = {},
            variant = TextFieldVariant.Outlined,
            style = AppTextFieldStyle(
                placeholderText = "Search...",
                placeholderColor = colors.contentSecondary,
                focusedBorderColor = colors.borderPrimary,
                unfocusedBorderColor = colors.borderTertiary,
                errorBorderColor = colors.borderNegative,
                cursorColor = colors.contentPrimary,
                backgroundColor = colors.backgroundPrimary,
                cornerRadius = 8,
//                leadingIconSource = R.drawable.ic_menu_search,
                leadingIconWidth = 46,
                leadingIconHeight = 32,
                leadingIconTint = colors.contentSecondary,
                trailingIconSource = ImageIconSource.VectorIcon(Icons.Default.Close),
                trailingIconSize = 16,
                trailingIconTint = Color.White,
                trailingIconBackgroundColor = colors.contentPrimary,
                trailingIconBackgroundSize = 32
            ),
            onTrailingIconClick = {}
        )
    }
}
