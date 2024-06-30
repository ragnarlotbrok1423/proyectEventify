package com.example.eventify.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.eventify.R
import com.example.eventify.components.LargeSpace
import com.example.eventify.components.HugeSpace
import com.example.eventify.components.CustomContextText
import com.example.eventify.components.GradientButton
import com.example.eventify.components.GradientPasswordField
import com.example.eventify.components.GradientTextFieldWithIcons
import com.example.eventify.components.ImageMaxWidth
import com.example.eventify.components.MaxWidthText
import com.example.eventify.components.MediumSpace
import com.example.eventify.components.NavigationText
import com.example.eventify.ui.themes.EventifyTheme
import com.example.eventify.ui.themes.GRA_HOR_BLACK_PURPLE

@Composable
fun LoginScreenView(){
    Box(modifier = Modifier.fillMaxSize()) {


        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
        ImageMaxWidth(img = R.drawable.login_sheep)
//        GifImage(modifier = Modifier.fillMaxWidth(), R.drawable.welcome_sheep)

            Column(
                modifier = Modifier
                .width(dimensionResource(id = R.dimen.app_width)),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                CustomContextText(
                    text = stringResource(id = R.string.title_activity_login),
                    style = MaterialTheme.typography.displayMedium,
                    textAlign = TextAlign.Center,
                )

                CustomContextText(
                    text = stringResource(id = R.string.login_text),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                )

                MediumSpace()

                GradientTextFieldWithIcons(
                    stringResource(id = R.string.prompt_username),
                    stringResource(id = R.string.focused_username),
                    Icons.Rounded.Person,
                    KeyboardType.Text,
                )

                MediumSpace()

                GradientPasswordField(
                    stringResource(id = R.string.prompt_password),
                    stringResource(id = R.string.focused_password),
                    Icons.Rounded.Lock,
                )

                MaxWidthText(
                    text = stringResource(id = R.string.forgot_password),
                    textAlign = TextAlign.End,
                )

                HugeSpace()

                GradientButton(
                    text = stringResource(id = R.string.action_login),
                    gradient = GRA_HOR_BLACK_PURPLE,
                )

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        CustomContextText(
                            text = stringResource(id = R.string.to_register_text),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge,
                        )
                        NavigationText(
                            text = stringResource(id = R.string.title_activity_register),
                            textAlign = TextAlign.Center,
                        )
                }
                LargeSpace()
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview(){
    EventifyTheme(darkTheme = false){
        LoginScreenView()

        
    }
}
