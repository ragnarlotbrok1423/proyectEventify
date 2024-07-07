package com.dev.eventify.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.dev.eventify.R
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.GRA_HOR_BLACK_PURPLE
import com.dev.eventify.ui.themes.md_theme_light_onPrimary


////////////////////
// Button

@Composable
fun GradientButton(
    onClick: () -> Unit = { },
    text: String,
    gradient : Brush,
    ){
        val mutableInteractionSource = remember {
            MutableInteractionSource()
        }

        Button(
            onClick = onClick,
            modifier = Modifier
                .roundedAnimatedShadow(MaterialTheme.shapes.extraLarge, mutableInteractionSource)
                .background(gradient, MaterialTheme.shapes.extraLarge)
                .border(0.dp, Color.Transparent, MaterialTheme.shapes.extraLarge)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = MaterialTheme.shapes.extraLarge,
            interactionSource = mutableInteractionSource,

    ){
            ButtonText(text = text.uppercase(),
            )
        }
}

@Composable
fun OutlineButton(
    onClick: () -> Unit ={},
    text: String,
    ) {
    val mutableInteractionSource = remember {
        MutableInteractionSource()
    }

    Button(
        onClick = onClick,
        modifier = Modifier
            .roundedAnimatedShadow(MaterialTheme.shapes.extraLarge, mutableInteractionSource)
            .background(Color.Transparent, shape = MaterialTheme.shapes.extraLarge)
            .border(2.dp, brush = GRA_HOR_BLACK_PURPLE, shape = MaterialTheme.shapes.extraLarge)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = MaterialTheme.shapes.extraLarge
    ){
        ButtonText(text = text.uppercase(),
        )
    }
}


@Composable
fun IconBackButton(onClick: () -> Unit, color: Color){
    val zIndex = 3f

    Icon(
        imageVector = Icons.Outlined.ArrowBackIosNew,
        contentDescription = null,
        tint = color,
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.icon_button))
            .clickable(onClick = onClick)
            .zIndex(zIndex),

        )
}

@Preview
@Composable
fun ButtonComponentPreview(){
    EventifyTheme(darkTheme = false){

        Column {
            GradientButton(
                text = "Login",
                gradient = GRA_HOR_BLACK_PURPLE,
            )

            SmallSpace()

            OutlineButton(
                text = "register",
            )

            IconBackButton(onClick = {}, color = md_theme_light_onPrimary)

        }
    }
}
