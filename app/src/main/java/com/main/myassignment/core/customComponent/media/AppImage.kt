package com.main.myassignment.core.customComponent.media

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.imageLoader
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.main.myassignment.R
import com.main.myassignment.core.customComponent.media.model.AppImageStyle
import com.main.myassignment.core.customComponent.media.model.ImageIconSource
import com.main.myassignment.core.util.isGif
import com.main.myassignment.core.util.normalizeFileSource
import com.main.myassignment.presentation.theme.dimens.sdp

/**
 *
 * One universal image component that handles:
 *
 * ✔ Drawable
 * ✔ GIF
 * ✔ Assets
 * ✔ URL
 * ✔ Local File
 * ✔ Content URIs
 */

@Composable
fun AppImage(
    source: Any?, // URL, drawable, asset, file, etc
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    style: AppImageStyle = AppImageStyle()
) {
    val context = LocalContext.current
    var imgModifier = modifier

    imgModifier = if (style.width != 0) {
        imgModifier.width(style.width.dp)
    } else {
        imgModifier.fillMaxWidth()
    }
    imgModifier = if (style.height != 0) {
        imgModifier.height(style.height.dp)
    } else {
        imgModifier.fillMaxHeight()
    }
    if (style.clip) {
        imgModifier = when {
            style.shape != null -> imgModifier.clip(style.shape)
            style.cornerRadius > 0 -> imgModifier.clip(RoundedCornerShape(style.cornerRadius.dp))
            else -> imgModifier
        }
    }
    if (style.backgroundColor != Color.Unspecified) {
        imgModifier = imgModifier.background(style.backgroundColor)
    }

    when (source) {
        is Int -> {
            // For drawable resources, use Icon composable if tint is needed for better control
            if (style.tintColor != Color.Unspecified && style.tintColor != Color.Transparent) {
                Icon(
                    painter = painterResource(source),
                    contentDescription = contentDescription,
                    modifier = imgModifier,
                    tint = style.tintColor
                )
            } else {
                Image(
                    painter = painterResource(source),
                    contentDescription = contentDescription,
                    modifier = imgModifier,
                    contentScale = style.contentScale
                )
            }
        }

        is ImageIconSource -> {
            val painter: Painter = when (source) {
                is ImageIconSource.PainterIcon -> painterResource(source.icon)
                is ImageIconSource.BitmapIcon -> remember(source.bitmap) {
                    BitmapPainter(source.bitmap)
                }

                is ImageIconSource.VectorIcon -> rememberVectorPainter(source.imageVector)
                is ImageIconSource.UrlIcon -> rememberAsyncImagePainter(model = source.url)
            }

            Icon(
                tint = style.tintColor,
                painter = painter,
                contentDescription = contentDescription,
                modifier = modifier
            )
        }

        is String -> {
            val imageLoader = if (isGif(source)) {
                remember {
                    ImageLoader.Builder(context)
                        .components { add(GifDecoder.Factory()) }
                        .build()
                }
            } else {
                context.imageLoader
            }
            val model = ImageRequest.Builder(context)
                .data(normalizeFileSource(source))
                .crossfade(true)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.ENABLED)
                .apply {
                    style.placeholder?.let { placeholder(it) }
                    style.error?.let { error(it) }
                }
                .build()

            SubcomposeAsyncImage(
                model = model,
                imageLoader = imageLoader,
                modifier = imgModifier,
                contentScale = style.contentScale,
                contentDescription = contentDescription,
                colorFilter = if (style.tintColor != Color.Unspecified && style.tintColor != Color.Transparent) {
                    ColorFilter.tint(style.tintColor)
                } else {
                    null
                }
            )
        }

        else -> {
            Box(
                modifier = imgModifier
                    .fillMaxSize()
                    .background(Color.LightGray.copy(alpha = 0.2f))
            )
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = false,
)
private fun AppImagePreview() {
    // Use a remote image URL for reliable Compose Preview rendering
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.sdp)
    ) {
        val (mediaRef) = createRefs()
        AppImage(
            source = R.drawable.ic_launcher_background,
            style = AppImageStyle(
                height = 280,
                width = 0,

            ),
            modifier = Modifier
                .constrainAs(mediaRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
        )
    }
}
