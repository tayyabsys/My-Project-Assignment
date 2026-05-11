package com.main.myassignment.core.customComponent.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.main.myassignment.core.customComponent.button.model.AppIconButtonStyle
import com.main.myassignment.core.customComponent.media.AppImage
import com.main.myassignment.core.customComponent.media.model.AppImageStyle
import com.main.myassignment.presentation.theme.dimens.sdp

/**
 * Icon button with style class support
 * Uses AppIconButtonStyle for configuration
 *
 * @param onClick Click handler
 * @param style Style configuration using AppIconButtonStyle
 * @param modifier Modifier for the button
 */
@Composable
fun AppIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: AppIconButtonStyle = AppIconButtonStyle()
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .background(
                color = if (style.enabled) {
                    style.backgroundColor
                } else {
                    style.backgroundColor.copy(
                        alpha = 0.4f
                    )
                },
                shape = IconButtonDefaults.filledShape
            )
            .padding(style.padding.sdp),
        enabled = style.enabled
    ) {
        when (style.icon) {
            is ImageVector -> {
                // Use Material Icon directly
                Icon(
                    imageVector = style.icon,
                    contentDescription = style.contentDescription,
                    tint = if (style.enabled) style.tint else style.tint.copy(alpha = 0.4f),
                    modifier = Modifier.size(style.iconSize.sdp)
                )
            }

            is String, is Int -> {
                // Use AppImage for URL or drawable resource
                if ((style.icon is String && style.icon.isNotEmpty()) || style.icon is Int) {
                    AppImage(
                        source = style.icon,
                        contentDescription = style.contentDescription,
                        style = AppImageStyle(
                            width = style.iconSize,
                            height = style.iconSize
                        ),
                        modifier = Modifier.size(style.iconSize.sdp)
                    )
                } else if (style.fallbackIcon != null) {
                    // Use fallback icon if provided and main icon is empty
                    Icon(
                        imageVector = style.fallbackIcon,
                        contentDescription = style.contentDescription,
                        tint = if (style.enabled) style.tint else style.tint.copy(alpha = 0.4f),
                        modifier = Modifier.size(style.iconSize.sdp)
                    )
                }
            }

            else -> {
                // Try to use AppImage for any other type
                if (style.icon != null) {
                    AppImage(
                        source = style.icon,
                        contentDescription = style.contentDescription,
                        style = AppImageStyle(
                            width = style.iconSize,
                            height = style.iconSize,
                            tintColor = style.tint
                        ),
                        modifier = Modifier.size(style.iconSize.sdp)
                    )
                } else if (style.fallbackIcon != null) {
                    // Use fallback icon if main icon is null
                    Icon(
                        imageVector = style.fallbackIcon,
                        contentDescription = style.contentDescription,
                        tint = if (style.enabled) style.tint else style.tint.copy(alpha = 0.4f),
                        modifier = Modifier.size(style.iconSize.sdp)
                    )
                }
            }
        }
    }
}
