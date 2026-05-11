package com.main.myassignment.core.customComponent.text.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.main.myassignment.R
import com.main.myassignment.presentation.theme.color.LocalAppExtendedColor
import com.main.myassignment.presentation.theme.dimens.ssp


object AppTextStyle {

    // Font Families
    private val robotoLt = FontFamily(
        Font(R.font.roboto_light, FontWeight.Normal)
    )

    private val robotoRg = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_bold, FontWeight.Bold)
    )

    /**
     * H1 Light Style
     * Font: roboto Light, Size: 32ssp, Line Height: 40ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h1Light(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoLt,
        fontWeight = FontWeight.Normal,
        fontSize = 32.ssp,
        lineHeight = 40.ssp,
        color = color
    )

    /**
     * H1 Regular Style
     * Font: roboto Regular, Size: 32ssp, Line Height: 40ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h1Regular(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Normal,
        fontSize = 32.ssp,
        lineHeight = 40.ssp,
        color = color
    )

    /**
     * H2 Bold Style
     * Font: roboto Regular Bold, Size: 28ssp, Line Height: 36ssp, Weight: Bold
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h2Bold(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Bold,
        fontSize = 28.ssp,
        lineHeight = 36.ssp,
        color = color
    )

    /**
     * H2 Light Style
     * Font: roboto Light, Size: 28ssp, Line Height: 36ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h2Light(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoLt,
        fontWeight = FontWeight.Normal,
        fontSize = 28.ssp,
        lineHeight = 36.ssp,
        color = color
    )

    /**
     * H2 Regular Style
     * Font: roboto Regular, Size: 28ssp, Line Height: 36ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h2Regular(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Normal,
        fontSize = 28.ssp,
        lineHeight = 36.ssp,
        color = color
    )

    /**
     * H3 Bold Style
     * Font: roboto Regular Bold, Size: 24ssp, Line Height: 30ssp, Weight: Bold
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h3Bold(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Bold,
        fontSize = 24.ssp,
        lineHeight = 30.ssp,
        color = color
    )

    /**
     * H3 Light Style
     * Font: roboto Light, Size: 24ssp, Line Height: 30ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h3Light(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoLt,
        fontWeight = FontWeight.Normal,
        fontSize = 24.ssp,
        lineHeight = 30.ssp,
        color = color
    )

    /**
     * H3 Regular Style
     * Font: roboto Regular, Size: 24ssp, Line Height: 30ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h3Regular(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Normal,
        fontSize = 24.ssp,
        lineHeight = 30.ssp,
        color = color
    )

    /**
     * H4 Bold Style
     * Font: roboto Regular Bold, Size: 20ssp, Line Height: 28ssp, Weight: Bold
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h4Bold(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Bold,
        fontSize = 20.ssp,
        lineHeight = 28.ssp,
        color = color
    )

    /**
     * H4 Regular Style
     * Font: roboto Regular, Size: 20ssp, Line Height: 28ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h4Regular(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Normal,
        fontSize = 20.ssp,
        lineHeight = 28.ssp,
        color = color
    )

    /**
     * H5 Bold Style
     * Font: roboto Regular Bold, Size: 18ssp, Line Height: 24ssp, Weight: Bold
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h5Bold(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Bold,
        fontSize = 18.ssp,
        lineHeight = 24.ssp,
        color = color
    )

    /**
     * H5 Regular Style
     * Font: roboto Regular, Size: 18ssp, Line Height: 24ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun h5Regular(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Normal,
        fontSize = 18.ssp,
        lineHeight = 24.ssp,
        color = color
    )

    /**
     * Body Bold Style
     * Font: roboto Regular Bold, Size: 16ssp, Line Height: 22ssp, Weight: Bold
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun bodyBold(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Bold,
        fontSize = 16.ssp,
        lineHeight = 22.ssp,
        color = color
    )

    /**
     * Body Regular Style
     * Font: roboto Regular, Size: 16ssp, Line Height: 22ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun bodyRegular(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Normal,
        fontSize = 16.ssp,
        lineHeight = 22.ssp,
        color = color
    )

    /**
     * Mobile Footnote Regular Style
     * Font: roboto Regular, Size: 14ssp, Line Height: 18ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun mobileFootnoteRegular(color: Color = LocalAppExtendedColor.current.contentPrimary) =
        TextStyle(
            fontFamily = robotoRg,
            fontWeight = FontWeight.Normal,
            fontSize = 14.ssp,
            lineHeight = 18.ssp,
            color = color
        )

    /**
     * Footnote Style
     * Font: roboto Regular, Size: 14ssp, Line Height: 18ssp, Weight: Normal
     * @param color Text color, defaults to contentPrimary from theme (adapts to light/dark mode)
     */
    @Composable
    fun footnote(color: Color = LocalAppExtendedColor.current.contentPrimary) = TextStyle(
        fontFamily = robotoRg,
        fontWeight = FontWeight.Normal,
        fontSize = 14.ssp,
        lineHeight = 18.ssp,
        color = color
    )
}
