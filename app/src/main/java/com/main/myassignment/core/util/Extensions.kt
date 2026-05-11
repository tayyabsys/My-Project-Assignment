package com.main.myassignment.core.util

import android.graphics.Typeface
import android.net.Uri
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.util.Patterns
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.core.text.HtmlCompat
import java.io.File

fun String.isValidEmail(): Boolean =
    Patterns.EMAIL_ADDRESS.matcher(this).matches()


fun String.toAnnotatedStringFromHtml(): AnnotatedString {
    // Support \n
    val processed = this.replace("\n", "<br>")

    val spanned = HtmlCompat.fromHtml(processed, HtmlCompat.FROM_HTML_MODE_LEGACY)

    return buildAnnotatedString {
        append(spanned.toString())

        val spans = spanned.getSpans(0, spanned.length, Any::class.java)

        spans.forEach { span ->
            val start = spanned.getSpanStart(span)
            val end = spanned.getSpanEnd(span)

            when (span) {
                is StyleSpan -> when (span.style) {
                    Typeface.BOLD -> addStyle(
                        SpanStyle(fontWeight = FontWeight.Bold),
                        start,
                        end
                    )

                    Typeface.ITALIC -> addStyle(
                        SpanStyle(fontStyle = FontStyle.Italic),
                        start,
                        end
                    )

                    Typeface.BOLD_ITALIC -> addStyle(
                        SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        ),
                        start,
                        end
                    )
                }

                is UnderlineSpan -> addStyle(
                    SpanStyle(textDecoration = TextDecoration.Underline),
                    start,
                    end
                )

                is ForegroundColorSpan -> addStyle(
                    SpanStyle(color = Color(span.foregroundColor)),
                    start,
                    end
                )

                is URLSpan -> addStyle(
                    SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    ),
                    start,
                    end
                )
            }
        }
    }
}
object FileTypeExt {
    const val JSON_EXTENSION = ".json"
    const val ZIP_EXTENSION = ".zip"
    const val PNG_EXTENSION = ".png"
    const val JPG_EXTENSION = ".jpg"
    const val JPEG_EXTENSION = ".jpeg"
    const val GIF_EXTENSION = ".gif"
    const val MP4_EXTENSION = ".mp4"
}
object FilePrefix {
    const val ASSET_PREFIX = "file:///android_asset/"
    const val FILE_PREFIX = "file://"
    const val CONTENT_PREFIX = "content://"
    const val HTTP_PREFIX = "http"
}
fun normalizeFileSource(value: Any?): Any? {
    return when (value) {
        null -> { null }

        // Already a valid type
        is Int -> { value } // drawable resource
        is Uri -> { value }
        is File -> { value }
        is ByteArray -> { value }

        // Asset path → convert to asset URI
        is String -> {
            when {
                value.startsWith(FilePrefix.HTTP_PREFIX) -> value // URL
                value.startsWith(FilePrefix.ASSET_PREFIX) -> value // asset
                value.startsWith(FilePrefix.FILE_PREFIX) -> value // local file URI
                value.startsWith(FilePrefix.CONTENT_PREFIX) -> value // content resolver
                else -> value // treat as URL or fallback
            }
        }

        else -> { value }
    }
}

fun isGif(source: Any?): Boolean {
    return (source is String && source.endsWith(FileTypeExt.GIF_EXTENSION, ignoreCase = true))
}
