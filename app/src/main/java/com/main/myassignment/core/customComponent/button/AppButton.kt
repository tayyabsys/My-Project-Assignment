package com.main.myassignment.core.customComponent.button

import android.R.attr.textStyle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.myassignment.core.customComponent.button.model.AppButtonStyle
import com.main.myassignment.core.customComponent.button.model.ButtonVariant
import com.main.myassignment.core.customComponent.text.AppText
import com.main.myassignment.core.customComponent.text.model.AppTextStyle
import com.main.myassignment.presentation.theme.color.MVARedColor
import com.main.myassignment.presentation.theme.dimens.sdp

/**
 * A generic, optimized button component that supports multiple variants:
 * - Filled: Standard button with gradient background
 * - Outlined: Button with border and transparent background
 * - Text: Borderless button with transparent background
 *
 * Features:
 * - Supports leading and trailing icons
 * - Gradient backgrounds for filled variant
 * - Highly customizable through GenericButtonStyle
 * - Consistent API across all variants
 *
 * @param text The button text to display
 * @param onClick Callback when button is clicked
 * @param modifier Modifier for the button
 * @param textStyle Text style for the button text
 * @param style Button style configuration
 * @param variant Button variant (Filled, Outlined, or Text)
 */
@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: AppButtonStyle = AppButtonStyle(),
    variant: ButtonVariant = ButtonVariant.Filled
) {
    // Use bodyRegular as default if textStyle is null
    val effectiveTextStyle = style.textStyle ?: AppTextStyle.bodyRegular()

    val cornerRadius = RoundedCornerShape(style.cornerRadius.sdp)
    val contentPadding = PaddingValues(
        horizontal = style.horizontalContentPadding.sdp,
        vertical = style.verticalContentPadding.sdp
    )

    // Determine colors based on variant and enabled state
    val (containerColor, contentColor, border) = when (variant) {
        ButtonVariant.Filled -> {
            if (style.enabled) {
                style.gradientEnabledColors
            } else {
                style.gradientDisabledColors
            }
            Triple(Color.Transparent, effectiveTextStyle.color, style.borderWidth.dp)
        }

        ButtonVariant.Outlined -> {
            Triple(
                style.backgroundColor ?: Color.Transparent,
                effectiveTextStyle.color,
                style.borderWidth.dp
            )
        }

        ButtonVariant.Text -> {
            Triple(Color.Transparent, effectiveTextStyle.color, 0.dp)
        }
    }

    // Background gradient for filled variant
    val backgroundModifier = when (variant) {
        ButtonVariant.Filled -> {
            if (style.backgroundColor == null) {
                val gradient = if (style.enabled) {
                    Brush.linearGradient(colors = style.gradientEnabledColors)
                } else {
                    Brush.linearGradient(colors = style.gradientDisabledColors)
                }
                Modifier
                    .clip(cornerRadius)
                    .background(brush = gradient, shape = cornerRadius)
            } else {
                Modifier
                    .clip(cornerRadius)
                    .background(color = style.backgroundColor, shape = cornerRadius)
            }
        }

        ButtonVariant.Outlined, ButtonVariant.Text -> {
            style.backgroundColor?.let {
                Modifier
                    .clip(cornerRadius)
                    .background(color = it, shape = cornerRadius)
            } ?: Modifier
        }
    }

    Button(
        onClick = onClick,
        enabled = style.enabled,
        modifier = modifier
            .then(backgroundModifier.padding(0.dp)),
        shape = cornerRadius,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor,
            disabledContentColor = contentColor.copy(alpha = 0.6f)
        ),
        contentPadding = contentPadding,
        border = if (variant == ButtonVariant.Outlined) {
            BorderStroke(border, style.borderColor)
        } else {
            null
        }
    ) {
        ButtonContent(
            text = text,
            textStyle = effectiveTextStyle,
            style = style,
            enabled = style.enabled,
            variant = variant
        )
    }
}

@Composable
private fun ButtonContent(
    text: String,
    textStyle: TextStyle,
    style: AppButtonStyle,
    enabled: Boolean,
    variant: ButtonVariant
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Leading Icon
        style.leadingIcon?.let { icon ->
            ButtonIcon(
                painter = icon,
                size = style.leadingIconSize,
                tint = style.iconTint,
                enabled = enabled
            )
            Spacer(modifier = Modifier.width(8.sdp))
        }

        // Button Text
        AppText(
            text = text,
            style = textStyle.copy(
                color = when {
                    !enabled -> textStyle.color.copy(alpha = 0.6f)
                    variant == ButtonVariant.Filled -> textStyle.color
                    else -> textStyle.color
                }
            ),
            maxLines = 1,
        )

        // Trailing Icon
        style.trailingIcon?.let { icon ->
            Spacer(modifier = Modifier.width(8.sdp))
            ButtonIcon(
                painter = icon,
                size = style.trailingIconSize,
                tint = style.iconTint,
                enabled = enabled
            )
        }
    }
}

@Composable
private fun ButtonIcon(
    painter: Painter,
    size: Int,
    tint: Color,
    enabled: Boolean
) {
    Icon(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.size(size.sdp),
        tint = if (enabled) tint else tint.copy(alpha = 0.6f)
    )
}

// ============================================
// Preview Functions
// ============================================

@Preview(
    showBackground = true,
    name = "Filled Button",
    device = "spec:width=390dp,height=850.9dp,dpi=640"
)
@Composable
private fun GenericButtonFilledPreview() {
    AppButton(
        text = "Skip",
        onClick = {},
        style = AppButtonStyle(
            verticalContentPadding = 0,
            horizontalContentPadding = 20, // With Default size of button
            enabled = true,
            cornerRadius = 8
        ),
        variant = ButtonVariant.Filled,
        modifier = Modifier
            .padding(20.dp)
            .height(32.dp)
            .wrapContentWidth()

    )
}

@Preview(showBackground = true, name = "Outlined Button")
@Composable
private fun GenericButtonOutlinedPreview() {
    AppButton(
        text = "Outlined Button",
        onClick = {},
        style = AppButtonStyle(
            verticalContentPadding = 12,
            enabled = true,
            cornerRadius = 30,
            borderColor = MVARedColor,
            textStyle = AppTextStyle.bodyRegular(
                color = MVARedColor,
                // fontSize = WelcomeConstants.SHEET_BUTTON_FONT_SIZE.ssp,
            )
        ),
        variant = ButtonVariant.Outlined,
        modifier = Modifier
            .padding(13.sdp)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true, name = "Text Button")
@Composable
private fun GenericButtonTextPreview() {
    AppButton(
        text = "Text Button",
        onClick = {},
        style = AppButtonStyle(
            verticalContentPadding = 8,
            enabled = true
        ),
        variant = ButtonVariant.Text,
        modifier = Modifier
            .padding(13.sdp)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true, name = "Disabled Button")
@Composable
private fun GenericButtonDisabledPreview() {
    AppButton(
        text = "Disabled Button",
        onClick = {},
        style = AppButtonStyle(
            verticalContentPadding = 12,
            enabled = false,
            cornerRadius = 30
        ),
        variant = ButtonVariant.Filled,
        modifier = Modifier
            .padding(13.sdp)
            .fillMaxWidth()
    )
}
