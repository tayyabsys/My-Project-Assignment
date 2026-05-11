package com.main.myassignment.presentation.theme.color

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class AppExtendedColor(
    // Background Colors
    val backgroundApp: Color,
    val backgroundBrand: Color,
    val backgroundBrandHover: Color,
    val backgroundBrandPressed: Color,
    val backgroundDisabled: Color,
    val backgroundHover: Color,
    val backgroundInfo: Color,
    val backgroundInfoSubtle: Color,
    val backgroundInverse: Color,
    val backgroundNegative: Color,
    val backgroundNegativeSubtle: Color,
    val backgroundNotice: Color,
    val backgroundNoticeSubtle: Color,
    val backgroundPositive: Color,
    val backgroundPositiveSubtle: Color,
    val backgroundPrimary: Color,
    val backgroundSecondary: Color,
    val backgroundSelected: Color,
    val backgroundTertiary: Color,

    // Border Colors
    val borderBrand: Color,
    val borderFocus: Color,
    val borderInfo: Color,
    val borderInverse: Color,
    val borderMono: Color,
    val borderNegative: Color,
    val borderNotice: Color,
    val borderPositive: Color,
    val borderPrimary: Color,
    val borderSecondary: Color,
    val borderTertiary: Color,

    // Content Colors
    val content: Color,
    val contentBrand: Color,
    val contentBlueIcons: Color,
    val contentDisabled: Color,
    val contentInfo: Color,
    val contentInfoBold: Color,
    val contentLink: Color,
    val contentLinkHover: Color,
    val contentLinkPressed: Color,
    val contentNegative: Color,
    val contentNegativeBold: Color,
    val contentNotice: Color,
    val contentNoticeBold: Color,
    val contentPositive: Color,
    val contentPositiveBold: Color,
    val contentPrimary: Color,
    val contentSecondary: Color,
    val contentTertiary: Color,
    val contentUnique: Color,
    val contentUniqueBold: Color,

    // Background Colors - Additional
    val backgroundRedCard: Color,
    val backgroundRedCardDark: Color,
    val backgroundTabsDisabled: Color,
    val backgroundTabsSelected: Color,

    // Border Colors - Additional
    val borderInputStroke: Color,
    val borderInputStrokeActive: Color,
    val borderInputStrokeError: Color,
    val borderKYC: Color,
    val borderKYCSet: Color,
    val borderSeparator: Color,

    // Gradient Colors - Black
    val gradientBlackStart: Color,
    val gradientBlackCenter: Color,
    val gradientBlackEnd: Color,

    // Gradient Colors - Bronze
    val gradientBronzeStart: Color,
    val gradientBronzeEnd: Color,

    // Gradient Colors - Gold
    val gradientGoldStart: Color,
    val gradientGoldEnd: Color,

    // Gradient Colors - Red
    val gradientRedStart: Color,
    val gradientRedEnd: Color,

    // Gradient Colors - Red Dark
    val gradientRedDarkStart: Color,
    val gradientRedDarkEnd: Color,

    // Gradient Colors - Silver
    val gradientSilverStart: Color,
    val gradientSilverCenter: Color,
    val gradientSilverEnd: Color,

    // Other Colors
    val overlay: Color,
    val shadow: Color,
    val shadowAvatar: Color,

    val receiptPopup: Color
)

/**
 * Light theme extended colors
 */
val LightAppExtendedColor = AppExtendedColor(
    // Background Colors
    backgroundApp = AppBackgroundColor,
    backgroundBrand = BrandColor,
    backgroundBrandHover = BrandHoverColor,
    backgroundBrandPressed = BrandPressedColor,
    backgroundDisabled = DisabledBackgroundColor,
    backgroundHover = HoverBackgroundColor,
    backgroundInfo = InfoColor,
    backgroundInfoSubtle = InfoSubtleColor,
    backgroundInverse = InverseBackgroundColor,
    backgroundNegative = NegativeColor,
    backgroundNegativeSubtle = NegativeSubtleColor,
    backgroundNotice = NoticeColor,
    backgroundNoticeSubtle = NoticeSubtleColor,
    backgroundPositive = PositiveColor,
    backgroundPositiveSubtle = PositiveSubtleColor,
    backgroundPrimary = PrimaryBackgroundColor,
    backgroundSecondary = SecondaryBackgroundColor,
    backgroundSelected = SelectedBackgroundColor,
    backgroundTertiary = TertiaryBackgroundColor,

    // Border Colors
    borderBrand = BrandColor,
    borderFocus = BorderFocusColor,
    borderInfo = BorderInfoColor,
    borderInverse = BorderInverseColor,
    borderMono = BorderMonoColor,
    borderNegative = NegativeColor,
    borderNotice = NoticeColor,
    borderPositive = PositiveColor,
    borderPrimary = BorderPrimaryColor,
    borderSecondary = BorderSecondaryColor,
    borderTertiary = BorderTertiaryColor,

    // Content Colors
    content = ContentColor,
    contentBrand = BrandColor,
    contentBlueIcons = ContentBlueIconsColor,
    contentDisabled = ContentDisabledColor,
    contentInfo = InfoColor,
    contentInfoBold = InfoBoldColor,
    contentLink = ContentLinkColor,
    contentLinkHover = ContentLinkHoverColor,
    contentLinkPressed = ContentLinkPressedColor,
    contentNegative = NegativeColor,
    contentNegativeBold = ContentNegativeBoldColor,
    contentNotice = NoticeColor,
    contentNoticeBold = NoticeBoldColor,
    contentPositive = PositiveColor,
    contentPositiveBold = PositiveBoldColor,
    contentPrimary = ContentPrimaryColor,
    contentSecondary = ContentSecondaryColor,
    contentTertiary = ContentTertiaryColor,
    contentUnique = ContentUniqueColor,
    contentUniqueBold = ContentUniqueBoldColor,

    // Background Colors - Additional
    backgroundRedCard = RedCardColor,
    backgroundRedCardDark = RedCardDarkColor,
    backgroundTabsDisabled = TabsDisabledColor,
    backgroundTabsSelected = TabsSelectedColor,

    // Border Colors - Additional
    borderInputStroke = InputStrokeColor,
    borderInputStrokeActive = InputStrokeActiveColor,
    borderInputStrokeError = InputStrokeErrorColor,
    borderKYC = KYCBorderColor,
    borderKYCSet = KYCBorderSetColor,
    borderSeparator = SeparatorColor,

    // Gradient Colors - Black
    gradientBlackStart = BlackGradientStartColor,
    gradientBlackCenter = BlackGradientCenterColor,
    gradientBlackEnd = BlackGradientEndColor,

    // Gradient Colors - Bronze
    gradientBronzeStart = BronzeGradientStartColor,
    gradientBronzeEnd = BronzeGradientEndColor,

    // Gradient Colors - Gold
    gradientGoldStart = GoldGradientStartColor,
    gradientGoldEnd = GoldGradientEndColor,

    // Gradient Colors - Red
    gradientRedStart = RedGradientStartColor,
    gradientRedEnd = RedGradientEndColor,

    // Gradient Colors - Red Dark
    gradientRedDarkStart = RedGradientDarkStartColor,
    gradientRedDarkEnd = RedGradientDarkEndColor,

    // Gradient Colors - Silver
    gradientSilverStart = SilverGradientStartColor,
    gradientSilverCenter = SilverGradientCenterColor,
    gradientSilverEnd = SilverGradientEndColor,

    // Other Colors
    overlay = OverlayColor,
    shadow = ShadowColor,
    shadowAvatar = ShadowAvatarColor,

    receiptPopup = ReceiptPopupColor
)

/**
 * Dark theme extended colors
 */
val DarkAppExtendedColor = AppExtendedColor(
    // Background Colors
    backgroundApp = AppBackgroundColorDark,
    backgroundBrand = BrandColorDark,
    backgroundBrandHover = BrandHoverColorDark,
    backgroundBrandPressed = BrandPressedColorDark,
    backgroundDisabled = DisabledBackgroundColorDark,
    backgroundHover = HoverBackgroundColorDark,
    backgroundInfo = InfoColor,
    backgroundInfoSubtle = InfoSubtleColorDark,
    backgroundInverse = InverseBackgroundColorDark,
    backgroundNegative = NegativeColorDark,
    backgroundNegativeSubtle = NegativeSubtleColorDark,
    backgroundNotice = NoticeColorDark,
    backgroundNoticeSubtle = NoticeSubtleColorDark,
    backgroundPositive = PositiveColorDark,
    backgroundPositiveSubtle = PositiveSubtleColorDark,
    backgroundPrimary = PrimaryBackgroundColorDark,
    backgroundSecondary = SecondaryBackgroundColorDark,
    backgroundSelected = SelectedBackgroundColorDark,
    backgroundTertiary = TertiaryBackgroundColorDark,

    // Border Colors
    borderBrand = BrandColorDark,
    borderFocus = BorderFocusColorDark,
    borderInfo = BorderInfoColorDark,
    borderInverse = BorderInverseColorDark,
    borderMono = BorderMonoColorDark,
    borderNegative = NegativeColorDark,
    borderNotice = NoticeColorDark,
    borderPositive = PositiveColorDark,
    borderPrimary = BorderPrimaryColorDark,
    borderSecondary = BorderSecondaryColorDark,
    borderTertiary = BorderTertiaryColorDark,

    // Content Colors
    content = ContentColorDark,
    contentBrand = BrandColorDark,
    contentBlueIcons = ContentBlueIconsColorDark,
    contentDisabled = ContentDisabledColorDark,
    contentInfo = InfoColor,
    contentInfoBold = InfoBoldColor,
    contentLink = ContentLinkColorDark,
    contentLinkHover = ContentLinkHoverColorDark,
    contentLinkPressed = ContentLinkPressedColorDark,
    contentNegative = NegativeColorDark,
    contentNegativeBold = ContentNegativeBoldColorDark,
    contentNotice = NoticeColorDark,
    contentNoticeBold = NoticeBoldColorDark,
    contentPositive = PositiveColorDark,
    contentPositiveBold = PositiveBoldColorDark,
    contentPrimary = ContentPrimaryColorDark,
    contentSecondary = ContentSecondaryColorDark,
    contentTertiary = ContentTertiaryColorDark,
    contentUnique = ContentUniqueColor,
    contentUniqueBold = ContentUniqueBoldColor,

    // Background Colors - Additional
    backgroundRedCard = RedCardColorDark,
    backgroundRedCardDark = RedCardDarkColorDark,
    backgroundTabsDisabled = TabsDisabledColorDark,
    backgroundTabsSelected = TabsSelectedColorDark,

    // Border Colors - Additional
    borderInputStroke = InputStrokeColorDark,
    borderInputStrokeActive = InputStrokeActiveColorDark,
    borderInputStrokeError = InputStrokeErrorColorDark,
    borderKYC = KYCBorderColorDark,
    borderKYCSet = KYCBorderSetColorDark,
    borderSeparator = SeparatorColorDark,

    // Gradient Colors - Black
    gradientBlackStart = BlackGradientStartColorDark,
    gradientBlackCenter = BlackGradientCenterColorDark,
    gradientBlackEnd = BlackGradientEndColorDark,

    // Gradient Colors - Bronze
    gradientBronzeStart = BronzeGradientStartColorDark,
    gradientBronzeEnd = BronzeGradientEndColorDark,

    // Gradient Colors - Gold
    gradientGoldStart = GoldGradientStartColorDark,
    gradientGoldEnd = GoldGradientEndColorDark,

    // Gradient Colors - Red
    gradientRedStart = RedGradientStartColorDark,
    gradientRedEnd = RedGradientEndColorDark,

    // Gradient Colors - Red Dark
    gradientRedDarkStart = RedGradientDarkStartColorDark,
    gradientRedDarkEnd = RedGradientDarkEndColorDark,

    // Gradient Colors - Silver
    gradientSilverStart = SilverGradientStartColorDark,
    gradientSilverCenter = SilverGradientCenterColorDark,
    gradientSilverEnd = SilverGradientEndColorDark,

    // Other Colors
    overlay = OverlayColor,
    shadow = ShadowColorDark,
    shadowAvatar = ShadowAvatarColorDark,

    receiptPopup = ReceiptPopupColorDark
)

/**
 * CompositionLocal for app extended colors
 */
val LocalAppExtendedColor = staticCompositionLocalOf { LightAppExtendedColor }
