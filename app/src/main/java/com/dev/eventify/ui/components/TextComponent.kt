package com.dev.eventify.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.dev.eventify.R
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.GRA_VER_PURPLE_WHITE
import com.dev.eventify.ui.themes.md_theme_light_onPrimaryContainer

@Composable
fun GradientTitleText(text: String, gradient: Brush){
    Text(text = text,
        style = TextStyle(gradient),
        fontSize = MaterialTheme.typography.displayMedium.fontSize,
        fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
        textAlign = TextAlign.Center
        )
}

@Composable
fun SubTitleText(text: String){
    Text(text = text,
        color = md_theme_light_onPrimaryContainer,
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
        )
}

@Composable
fun ButtonText(text: String){
    Text(
        text = text,
        style =  MaterialTheme.typography.titleLarge
    )
}

@Composable
fun ContextText(text: String,
                textAlign: TextAlign
){
    Text(
        text = text,
        modifier = Modifier
            .padding(
                top = dimensionResource(id = R.dimen.padding_smaller),
                bottom = dimensionResource(id = R.dimen.padding_smaller)),
        style = MaterialTheme.typography.labelLarge,
        textAlign = textAlign,
    )
}

@Composable
fun MaxWidthText(text: String,
                textAlign: TextAlign,
){
    Text(
        text = text,
        modifier = Modifier
            .padding(
                top = dimensionResource(id = R.dimen.padding_small),
                bottom = dimensionResource(id = R.dimen.padding_smaller)
            )
            .fillMaxWidth(),
        style = MaterialTheme.typography.labelLarge,
        textAlign = textAlign,
        color = md_theme_light_onPrimaryContainer,
    )
}

@Composable
fun NavigationText(
    text: String,
    onClick: () -> Unit = { },
    textAlign: TextAlign,
){
    ClickableText(
        text = AnnotatedString(text),
        onClick = {onClick()},
        style = TextStyle(
            color = colorResource(R.color.earth_yellow),
            fontSize = MaterialTheme.typography.labelLarge.fontSize,
            fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
            textAlign = textAlign
        ),
        modifier = Modifier
            .padding(
                top = dimensionResource(id = R.dimen.padding_smaller),
                bottom = dimensionResource(id = R.dimen.padding_smaller)
            ),
    )
}

@Composable
fun ErrorTextField(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.error
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFF
)
@Composable
fun TextPreview(){
    EventifyTheme(darkTheme = false){
        Column {
            GradientTitleText(text = "Eventify", gradient = GRA_VER_PURPLE_WHITE)
            SmallSpace()
            ContextText(text = "how's going",
                textAlign = TextAlign.Center,
            )
            SmallSpace()
            ButtonText(text = "button")
            SmallSpace()
            MaxWidthText(text = "heyyyyy",
                textAlign = TextAlign.Center,
                )
            ErrorTextField(text = "error")
        }
    }
}
