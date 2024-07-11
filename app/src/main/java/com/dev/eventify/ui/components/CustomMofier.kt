package com.dev.eventify.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.dev.eventify.R
import com.dev.eventify.ui.themes.GRA_HOR_LIGHT_PURPLE
import com.dev.eventify.ui.themes.md_theme_light_error
import com.dev.eventify.ui.themes.md_theme_light_errorContainer
import com.dev.eventify.ui.themes.md_theme_light_inverseSurface
import com.dev.eventify.ui.themes.md_theme_light_onPrimaryContainer
import com.dev.eventify.ui.themes.md_theme_light_onSurfaceVariant
import com.dev.eventify.ui.themes.md_theme_light_primary
import com.dev.eventify.ui.themes.md_theme_light_secondaryContainer
import com.dev.eventify.ui.themes.md_theme_light_shadow
import com.dev.eventify.ui.themes.md_theme_light_surfaceTint

@Composable
fun Modifier.roundedAnimatedShadow(shape: Shape, mutableInteractionSource: MutableInteractionSource): Modifier {

    var pressed = mutableInteractionSource.collectIsPressedAsState()
    var elevation = animateDpAsState(
        targetValue = if (pressed.value) {
            dimensionResource(id = R.dimen.elevation_medium)
        } else {
            dimensionResource(id = R.dimen.elevation_smaller)
        },
        label = stringResource(id = R.string.label_elevation)
    )

    return this then Modifier
        .graphicsLayer {
            this.shadowElevation = elevation.value.toPx()
            this.shape = shape
            this.clip = true
            this.ambientShadowColor = md_theme_light_shadow
            this.spotShadowColor = md_theme_light_shadow
        }
}

@Composable
fun Modifier.roundedShadow(shape: Shape): Modifier{
    return this then Modifier
            .shadow(
            elevation = dimensionResource(id = R.dimen.elevation_small),
            shape = shape,
            clip = true,
            ambientColor = md_theme_light_shadow,
            spotColor = md_theme_light_shadow
        )
}

@Composable
fun Modifier.gradientBlueBg(): Modifier{
    return this then Modifier
        .background(GRA_HOR_LIGHT_PURPLE, shape = MaterialTheme.shapes.extraSmall)
        .fillMaxWidth()
}

@Composable
fun Modifier.transparentBg(): Modifier{
    return this then Modifier
        .background(Color.Transparent, shape = MaterialTheme.shapes.extraSmall)
        .fillMaxWidth()
}

val TextInputColors: TextFieldColors
    @Composable
    get() = TextFieldDefaults.colors(
        focusedTextColor = md_theme_light_onPrimaryContainer,
        unfocusedTextColor = md_theme_light_secondaryContainer,
        disabledTextColor = md_theme_light_onSurfaceVariant,
        errorTextColor = md_theme_light_error,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor =Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        errorContainerColor = md_theme_light_errorContainer,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent,
        focusedLabelColor = md_theme_light_onPrimaryContainer,
        unfocusedLabelColor = md_theme_light_primary,
        disabledLabelColor = md_theme_light_onSurfaceVariant,
        errorLabelColor = md_theme_light_error,
    )

val OutlinedTextInputColors: TextFieldColors
    @Composable
    get() = TextFieldDefaults.colors(
        focusedTextColor = md_theme_light_onPrimaryContainer,
        unfocusedTextColor = md_theme_light_secondaryContainer,
        disabledTextColor = md_theme_light_onSurfaceVariant,
        errorTextColor = md_theme_light_error,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        errorContainerColor = md_theme_light_errorContainer,
        focusedIndicatorColor = md_theme_light_inverseSurface,
        unfocusedIndicatorColor = md_theme_light_surfaceTint,
        disabledIndicatorColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent,
        focusedLabelColor = md_theme_light_onPrimaryContainer,
        unfocusedLabelColor = md_theme_light_primary,
        disabledLabelColor = md_theme_light_onSurfaceVariant,
        errorLabelColor = md_theme_light_error,
    )