package com.main.myassignment.core.customComponent.text

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat

@Composable
fun AppHtmlTextView(html: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = {
            TextView(it).apply {
                text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
            }
        }
    )
}
