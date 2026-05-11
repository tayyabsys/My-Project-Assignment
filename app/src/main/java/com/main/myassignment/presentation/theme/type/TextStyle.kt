package com.main.myassignment.presentation.theme.type

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.main.myassignment.R
import com.main.myassignment.presentation.theme.dimens.UILineHeights
import com.main.myassignment.presentation.theme.dimens.UiFontSizes
import com.main.myassignment.presentation.theme.dimens.UiLetterSpacings


@Composable
fun CustomTextStyle(
    fontSize: TextUnit = UiFontSizes.medium,
    lineHeight: TextUnit = UILineHeights.medium,
    letterSpacing: TextUnit = UiLetterSpacings.normal,
    fontWeight: FontWeight = FontWeight.Normal
) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_bold, fontWeight)),
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

@Composable
fun RegularTextStyle(
    fontSize: TextUnit = UiFontSizes.medium,
    lineHeight: TextUnit = UILineHeights.medium,
    letterSpacing: TextUnit = UiLetterSpacings.normal,
    fontWeight: FontWeight = FontWeight.Normal
) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_regular, fontWeight)),
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

@Composable
fun BoldTextStyle(
    fontSize: TextUnit = UiFontSizes.medium,
    lineHeight: TextUnit = UILineHeights.medium,
    letterSpacing: TextUnit = UiLetterSpacings.normal,
    fontWeight: FontWeight = FontWeight.Bold
) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_regular, fontWeight)),
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

@Composable
fun SemiBoldTextStyle(
    fontSize: TextUnit = UiFontSizes.medium,
    lineHeight: TextUnit = UILineHeights.medium,
    letterSpacing: TextUnit = UiLetterSpacings.normal,
    fontWeight: FontWeight = FontWeight.SemiBold
) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_bold, fontWeight)),
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

@Composable
fun MediumTextStyle(
    fontSize: TextUnit = UiFontSizes.medium,
    lineHeight: TextUnit = UILineHeights.medium,
    letterSpacing: TextUnit = UiLetterSpacings.normal,
    fontWeight: FontWeight = FontWeight.Medium
) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_bold, fontWeight)),
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

@Composable
fun LightTextStyle(
    fontSize: TextUnit = UiFontSizes.medium,
    lineHeight: TextUnit = UILineHeights.medium,
    letterSpacing: TextUnit = UiLetterSpacings.normal,
    fontWeight: FontWeight = FontWeight.Light
) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_light, fontWeight)),
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

@Composable
fun ThinTextStyle(
    fontSize: TextUnit = UiFontSizes.medium,
    lineHeight: TextUnit = UILineHeights.medium,
    letterSpacing: TextUnit = UiLetterSpacings.normal,
    fontWeight: FontWeight = FontWeight.Thin
) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_bold, fontWeight)),
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

@Composable
fun ExtraBoldTextStyle(
    fontSize: TextUnit = UiFontSizes.medium,
    lineHeight: TextUnit = UILineHeights.medium,
    letterSpacing: TextUnit = UiLetterSpacings.normal,
    fontWeight: FontWeight = FontWeight.ExtraBold
) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_extra_bold, fontWeight)),
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)
