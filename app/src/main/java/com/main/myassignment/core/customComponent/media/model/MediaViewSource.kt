package com.main.myassignment.core.customComponent.media.model

import androidx.compose.ui.layout.ContentScale

// Supporting sealed class for better type safety
sealed class MediaViewSource {
    data class Image(val source: Any) : MediaViewSource()
    data class Gif(val source: String) : MediaViewSource()
    data class Lottie(val source: Any) : MediaViewSource()
    data class Video(val source: String) : MediaViewSource() // can be YouTube or mp4
}

// Extension function to map API model to MediaViewSource
fun MediaSourceModel.toMediaViewSourceWithStyle(): Pair<MediaViewSource, AppMediaStyle> {
    val viewSource = when (type.lowercase()) {
        "image" -> Pair(
            MediaViewSource.Image(source),
            AppMediaStyle(
                appImageStyle =
                    AppImageStyle(contentScale = ContentScale.Crop)
            )
        )

        "gif" -> Pair(MediaViewSource.Gif(source.toString()), AppMediaStyle())
        "lotte" -> Pair(MediaViewSource.Lottie(source), AppMediaStyle())
        "video" -> Pair(MediaViewSource.Video(source.toString()), AppMediaStyle())
        else -> Pair(MediaViewSource.Image(""), AppMediaStyle())
    }
    return viewSource
}
