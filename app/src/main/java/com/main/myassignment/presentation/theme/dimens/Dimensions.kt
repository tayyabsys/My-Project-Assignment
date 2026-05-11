package com.main.myassignment.presentation.theme.dimens

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private const val BASE_SCREEN_WIDTH_DP = 360f

@Composable
fun dimensionScaleFactor(): Float {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat()
    return screenWidthDp / BASE_SCREEN_WIDTH_DP
}

/**
 * Scalable dp (similar to sdp from XML)
 * Usage: 16.sdp
 */
@Suppress("TopLevelPropertyNaming")
val Int.sdp: Dp
    @Composable get() {
        val scale = dimensionScaleFactor()
        return (this * scale).dp
    }

/**
 * Scalable sp (similar to ssp from XML)
 * Usage: 14.ssp
 */
@Suppress("TopLevelPropertyNaming")
val Int.ssp: TextUnit
    @Composable get() {
        val scale = dimensionScaleFactor()
        return (this * scale).sp
    }

// ✅ Non-Composable version (for ConstraintSets, ViewModels, etc.)
fun dimensionScaleFactor(context: Context): Float {
    val displayMetrics = context.resources.displayMetrics
    val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
    return screenWidthDp / BASE_SCREEN_WIDTH_DP
}

// ✅ Extension for non-composable usage
fun Int.sdp(context: Context): Dp {
    val scale = dimensionScaleFactor(context)
    return (this * scale).dp
}

fun Int.ssp(context: Context): TextUnit {
    val scale = dimensionScaleFactor(context)
    return (this * scale).sp
}

/**
 * Convert Dp to px with current density
 */
@Composable
fun Dp.toPxValue(): Float {
    val density = LocalDensity.current
    return with(density) { this@toPxValue.toPx() }
}

/**
 * Convert px to Dp with current density
 */
@Composable
fun Float.toDpValue(): Dp {
    val density = LocalDensity.current
    return with(density) { this@toDpValue.toDp() }
}
