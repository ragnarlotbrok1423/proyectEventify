package com.dev.eventify.components

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

@Composable
fun GradientTitleText(text: String, gradient: Brush){
    Text(text = text,
        style = TextStyle(gradient),
        fontSize = MaterialTheme.typography.displayLarge.fontSize,
        fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
        )
}

@Composable
fun CustomContextText(text: String,
                      style: TextStyle,
                      textAlign: TextAlign
){
    Text(
        text = text,
        modifier = Modifier
            .padding(
                top = dimensionResource(id = R.dimen.padding_smaller),
                bottom = dimensionResource(id = R.dimen.padding_smaller)),
        style = style,
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
        style = MaterialTheme.typography.bodyLarge,
        textAlign = textAlign,
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
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
            textAlign = textAlign
        ),
        modifier = Modifier
            .padding(
                top = dimensionResource(id = R.dimen.padding_smaller),
                bottom = dimensionResource(id = R.dimen.padding_smaller)
            )
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
            CustomContextText(text = "how's going",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
            )
            SmallSpace()
            MaxWidthText(text = "heyyyyy",
                textAlign = TextAlign.Center,
                )
        }
    }
}
