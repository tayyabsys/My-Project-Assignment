package com.main.myassignment.core.customComponent.media

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest

@Deprecated("Use AppImageView")
@Composable
fun AppGenericImageView(
    url: String,
    modifier: Modifier = Modifier,
    placeholder: Int = androidx.viewpager.R.color.ripple_material_light
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url.ifEmpty { placeholder })
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build(),
        contentDescription = url,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}
