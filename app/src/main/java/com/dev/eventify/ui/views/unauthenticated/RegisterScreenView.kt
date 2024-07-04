package com.dev.eventify.ui.views.unauthenticated

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.dev.eventify.R
import com.dev.eventify.ui.components.ContextText
import com.dev.eventify.ui.components.SelectTextField
import com.dev.eventify.ui.components.GradientButton
import com.dev.eventify.ui.components.GradientPasswordField
import com.dev.eventify.ui.components.GradientPhoneTextField
import com.dev.eventify.ui.components.GradientTextFieldWithIcons
import com.dev.eventify.ui.components.GradientTitleText
import com.dev.eventify.ui.components.ImageMaxWidth
import com.dev.eventify.ui.components.MaxWidthText
import com.dev.eventify.ui.components.MediumSpace
import com.dev.eventify.ui.components.NavigationText
import com.dev.eventify.ui.components.SmallSpace
import com.dev.eventify.ui.components.SubTitleText
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.GRA_HOR_BLACK_PURPLE
import com.dev.eventify.ui.themes.GRA_VER_BLACK_PURPLE

@Composable
fun RegisterScreenView(

    navigateToLogin: () -> Unit,
    navigateToAuthenticatedRoute: () -> Unit,
    navigateBack: () -> Unit,
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Column(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.app_width)),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                GradientTitleText(
                    text = stringResource(id = R.string.action_register),
                    gradient = GRA_VER_BLACK_PURPLE,
                )

                SubTitleText(
                    text = stringResource(id = R.string.register_text),
                )

                MediumSpace()

                Column(
                    modifier = Modifier
                        .heightIn(dimensionResource(id = R.dimen.container_height), dimensionResource(R.dimen.container_height))
                        .verticalScroll(rememberScrollState())
                        .weight(1f, fill = false)
                        .fillMaxWidth(),
//                        .height(dimensionResource(id = R.dimen.container_height)),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    GradientTextFieldWithIcons(
                        stringResource(id = R.string.prompt_username),
                        stringResource(id = R.string.focused_username),
                        Icons.Rounded.Person,
                        KeyboardType.Text,
                    )

                    SmallSpace()

                    GradientTextFieldWithIcons(
                        stringResource(id = R.string.prompt_email),
                        stringResource(id = R.string.focused_email),
                        Icons.Rounded.Email,
                        KeyboardType.Email,
                    )

                    SmallSpace()

                    GradientPasswordField(
                        stringResource(id = R.string.prompt_password),
                        stringResource(id = R.string.focused_password),
                        Icons.Rounded.Lock,
                    )

                    SmallSpace()

                    GradientPasswordField(
                        stringResource(id = R.string.prompt_password_confirm),
                        stringResource(id = R.string.focused_password_confirm),
                        Icons.Outlined.Lock,
                    )

                    SmallSpace()

                    GradientPhoneTextField()

                    SmallSpace()

                    SelectTextField(
                        label = stringResource(id = R.string.prompt_faculty))

                    SmallSpace()

                    SelectTextField(label = stringResource(id = R.string.prompt_level))


                    SmallSpace()
                    SelectTextField(label = stringResource(id = R.string.prompt_carrer))

                    
                }

                Column (
                    modifier = Modifier.width(dimensionResource(id = R.dimen.container_width)),
                ) {
                    MaxWidthText(
                        text = stringResource(id = R.string.term_condition),
                        textAlign = TextAlign.Justify,
                    )
                }

                MediumSpace()

                GradientButton(
                    text = stringResource(id = R.string.action_register),
                    gradient = GRA_HOR_BLACK_PURPLE,
                )

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ContextText(
                        text = stringResource(id = R.string.to_register_text),
                        textAlign = TextAlign.Center,
                    )
                    NavigationText(
                        text = stringResource(id = R.string.title_activity_register),
                        textAlign = TextAlign.Center,
                    )
                }
                MediumSpace()
            }

            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom,
            ){
                ImageMaxWidth(
                    img = R.drawable.register_sheep)
            }
        }
    }

}

@Preview
@Composable
fun RegisterPreview(){
    EventifyTheme (darkTheme= false) {
//        RegisterScreenView()
    }
}