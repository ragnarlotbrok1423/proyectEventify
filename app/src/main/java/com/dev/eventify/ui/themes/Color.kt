package com.dev.eventify.ui.themes

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Theme Color
val md_theme_light_primary = Color(0xFF321F46)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFF4d306a)
val md_theme_light_onPrimaryContainer = Color(0xFF002114)
val md_theme_light_secondary = Color(0xFF4167A6)
val md_theme_light_onSecondary = Color(0xFFFCFDF8)
val md_theme_light_secondaryContainer = Color(0xFF5E8EB6)
val md_theme_light_onSecondaryContainer = Color(0xFF092016)
val md_theme_light_tertiary = Color(0xFF015B28)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFF6CDBAC)
val md_theme_light_onTertiaryContainer = Color(0xFF001F29)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFBFDF9)
val md_theme_light_onBackground = Color(0xFF191C1A)
val md_theme_light_surface = Color(0xFFFBFDF9)
val md_theme_light_onSurface = Color(0xFF191C1A)
val md_theme_light_surfaceVariant = Color(0xFFDBE5DD)
val md_theme_light_onSurfaceVariant = Color(0xFF404943)
val md_theme_light_outline = Color(0xFF707973)
val md_theme_light_inverseOnSurface = Color(0xFFEFF1ED)
val md_theme_light_inverseSurface = Color(0xFF2E312F)
val md_theme_light_inversePrimary = Color(0xFFBEF1F9)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF4A4F9F)
val md_theme_light_outlineVariant = Color(0xFFBFC9C2)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFF4d306a)
val md_theme_dark_onPrimary = Color(0xFFFFFFFF)
val md_theme_dark_primaryContainer = Color(0xFF321F46)

// Named Basic Color
val DARK_BLUE = Color(0xFF2A3673)
val DARKER_BLUE = Color(0xFF060731)
val LIGHT_PURPLE = Color(0xFFCED1FF)


// Gradient Colors
val GRA_HOR_BLACK_PURPLE = Brush.horizontalGradient(listOf(DARKER_BLUE, DARK_BLUE))
val GRA_HOR_BLUE_PURPLE = Brush.horizontalGradient(listOf(md_theme_light_inversePrimary, md_theme_light_secondaryContainer))
val GRA_HOR_LIGHT_PURPLE = Brush.horizontalGradient(listOf(LIGHT_PURPLE, md_theme_light_primaryContainer))

val GRA_VER_BLACK_PURPLE = Brush.verticalGradient(listOf(DARKER_BLUE, DARK_BLUE))
val GRA_VER_PURPLE_WHITE = Brush.verticalGradient(listOf(md_theme_light_surfaceTint, md_theme_light_onPrimary))
val GRA_VER_BLUE_PURPLE = Brush.verticalGradient(listOf(DARK_BLUE, md_theme_light_surfaceTint))



