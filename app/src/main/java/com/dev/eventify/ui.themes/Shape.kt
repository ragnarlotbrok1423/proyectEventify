package com.dev.eventify.ui.themes

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shape = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(36.dp)
)