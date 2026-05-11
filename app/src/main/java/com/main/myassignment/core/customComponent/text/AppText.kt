package com.main.myassignment.core.customComponent.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.main.myassignment.core.customComponent.text.model.AppTextStyle
import com.main.myassignment.core.util.toAnnotatedStringFromHtml
import com.main.myassignment.presentation.theme.dimens.sdp


@Composable
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color? = null,
    fontSize: TextUnit? = null,
    fontWeight: FontWeight? = null,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = AppTextStyle.h2Regular(),
    textAlign: TextAlign = TextAlign.Unspecified
) {
    val finalStyle = style.copy(
        color = color ?: style.color,
        fontSize = fontSize ?: style.fontSize,
        fontWeight = fontWeight ?: style.fontWeight
    )

    val annotated = text.toAnnotatedStringFromHtml()
    Text(
        text = annotated,
        style = finalStyle,
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLines
    )
}

@Preview(showSystemUi = true)
@Composable
private fun AppTextPreview() {
    AppText(
        text = "This is <b>bold</b> \nand <font color='#FF0000'>red</font>!",
        style = AppTextStyle.h2Bold(),
        modifier = Modifier.padding(top = 20.sdp),
    )
}
