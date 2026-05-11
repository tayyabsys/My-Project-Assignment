package com.main.myassignment.core.customComponent.media.model

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ImageIconSource {
    data class PainterIcon(val icon: Int) : ImageIconSource()
    data class BitmapIcon(val bitmap: ImageBitmap) : ImageIconSource()
    data class VectorIcon(val imageVector: ImageVector) : ImageIconSource()
    data class UrlIcon(val url: String) : ImageIconSource()
}
