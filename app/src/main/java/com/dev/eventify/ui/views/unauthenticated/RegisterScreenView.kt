package com.dev.eventify.ui.views.unauthenticated

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.eventify.R
import com.dev.eventify.ui.components.ContextText
import com.dev.eventify.ui.components.GapColumn
import com.dev.eventify.ui.components.SelectTextField
import com.dev.eventify.ui.components.GradientButton
import com.dev.eventify.ui.components.GradientPasswordField
import com.dev.eventify.ui.components.GradientPhoneTextField
import com.dev.eventify.ui.components.GradientTextFieldWithIcons
import com.dev.eventify.ui.components.GradientTitleText
import com.dev.eventify.ui.components.HugeSpace
import com.dev.eventify.ui.components.IconBackButton
import com.dev.eventify.ui.components.ImageMaxWidth
import com.dev.eventify.ui.components.MaxWidthText
import com.dev.eventify.ui.components.MediumSpace
import com.dev.eventify.ui.components.NavigationText
import com.dev.eventify.ui.components.ScrollableColumn
import com.dev.eventify.ui.components.SubTitleText
import com.dev.eventify.ui.components.TopStartColumn
import com.dev.eventify.ui.themes.DARK_BLUE
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.GRA_HOR_BLACK_PURPLE
import com.dev.eventify.ui.themes.GRA_VER_BLACK_PURPLE
import com.dev.eventify.ui.viewModels.unauthenticated.RegisterViewModel

@Composable
fun RegisterScreenView(
    registerViewModel: RegisterViewModel = viewModel(),
    navigateToLogin: () -> Unit,
    navigateToAuthenticatedRoute: () -> Unit,
    navigateBack: () -> Unit,
){

    val registrationState by remember {
        registerViewModel.registerState
    }

    if (registrationState.isRegisterSuccessful) {
        LaunchedEffect(key1 = true) {
            navigateToAuthenticatedRoute.invoke()
        }
    }
    else {
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            TopStartColumn {
                IconBackButton(onClick = { navigateBack.invoke() },
                    color = DARK_BLUE)
            }

            ScrollableColumn {

                GapColumn(
                    modifier = Modifier
                        .padding(vertical = dimensionResource(id = R.dimen.padding_none),
                            horizontal = dimensionResource(id = R.dimen.padding_medium),
                        )
                ) {

                    HugeSpace()

                    GradientTitleText(
                        text = stringResource(id = R.string.action_register),
                        gradient = GRA_VER_BLACK_PURPLE,
                    )

                    SubTitleText(
                        text = stringResource(id = R.string.register_text),
                    )

                    MediumSpace()

                    GradientTextFieldWithIcons(
                        stringResource(id = R.string.prompt_nickname),
                        stringResource(id = R.string.focused_nickname),
                        Icons.Rounded.Person,
                        KeyboardType.Text,
                    )

                    GradientTextFieldWithIcons(
                        stringResource(id = R.string.prompt_email),
                        stringResource(id = R.string.focused_email),
                        Icons.Rounded.Email,
                        KeyboardType.Email,
                    )

                    GradientPasswordField(
                        stringResource(id = R.string.prompt_password),
                        stringResource(id = R.string.focused_password),
                        Icons.Rounded.Lock,
                    )

                    GradientPasswordField(
                        stringResource(id = R.string.prompt_password_confirm),
                        stringResource(id = R.string.focused_password_confirm),
                        Icons.Outlined.Lock,
                    )

                    GradientPhoneTextField()

                    SelectTextField(
                        label = stringResource(id = R.string.prompt_faculty))

                    SelectTextField(label = stringResource(id = R.string.prompt_level))

                    SelectTextField(label = stringResource(id = R.string.prompt_career))


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
                        onClick = {
                            navigateToAuthenticatedRoute.invoke()
                        }
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
                            text = stringResource(id = R.string.title_activity_login),
                            textAlign = TextAlign.Center,
                            onClick = {
                                navigateToLogin.invoke()
                            }
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
}

@Preview
@Composable
fun RegisterPreview(){
    EventifyTheme (darkTheme= false) {
        RegisterScreenView(
            navigateBack = {},
            navigateToLogin = {},
            navigateToAuthenticatedRoute = {}
        )
    }
}