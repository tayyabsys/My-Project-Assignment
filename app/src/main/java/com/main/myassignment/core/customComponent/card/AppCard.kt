package com.main.myassignment.core.customComponent.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.main.myassignment.core.customComponent.card.model.AppCardStyle

/**
 * Generic reusable card component with customizable style
 *
 * @param modifier Modifier for the card
 * @param style Card style configuration
 * @param content Content to be displayed inside the card
 */
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    style: AppCardStyle = AppCardStyle(),
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = style.shape,
        border = BorderStroke(style.borderWidth, style.borderColor),
        colors = CardDefaults.cardColors(
            containerColor = style.backgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = style.elevation
        )
    ) {
        content()
    }
}
