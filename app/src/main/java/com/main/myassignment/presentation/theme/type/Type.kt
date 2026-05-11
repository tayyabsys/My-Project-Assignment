package com.main.myassignment.presentation.theme.type

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.main.myassignment.R
import com.main.myassignment.presentation.theme.dimens.UILineHeights
import com.main.myassignment.presentation.theme.dimens.UiFontSizes
import com.main.myassignment.presentation.theme.dimens.UiLetterSpacings

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = UiFontSizes.extraLarge,
        lineHeight = UILineHeights.huge,
        letterSpacing = UiLetterSpacings.normal
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = UiFontSizes.large,
        lineHeight = UILineHeights.extraLarge,
        letterSpacing = UiLetterSpacings.normal
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.Medium,
        fontSize = UiFontSizes.large,
        lineHeight = UILineHeights.large,
        letterSpacing = UiLetterSpacings.normal
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.Medium,
        fontSize = UiFontSizes.medium,
        lineHeight = UILineHeights.medium,
        letterSpacing = UiLetterSpacings.normal
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = UiFontSizes.medium,
        lineHeight = UILineHeights.medium,
        letterSpacing = UiLetterSpacings.normal
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = UiFontSizes.medium,
        lineHeight = UILineHeights.medium,
        letterSpacing = UiLetterSpacings.normal
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = UiFontSizes.small,
        lineHeight = UILineHeights.small,
        letterSpacing = UiLetterSpacings.normal
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = UiFontSizes.medium,
        lineHeight = UILineHeights.medium,
        letterSpacing = UiLetterSpacings.wide
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = UiFontSizes.small,
        lineHeight = UILineHeights.small,
        letterSpacing = UiLetterSpacings.wide
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold)),
        fontWeight = FontWeight.Medium,
        fontSize = UiFontSizes.small,
        lineHeight = UILineHeights.small,
        letterSpacing = UiLetterSpacings.wide
    )
)
