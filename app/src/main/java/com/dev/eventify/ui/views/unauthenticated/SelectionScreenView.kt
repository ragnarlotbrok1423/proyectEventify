package com.dev.eventify.ui.views.unauthenticated

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dev.eventify.R
import com.dev.eventify.ui.components.ExtraHugeSpace
import com.dev.eventify.ui.components.GapColumn
import com.dev.eventify.ui.components.GapRow
import com.dev.eventify.ui.components.GradientTitleText
import com.dev.eventify.ui.components.HugeSpace
import com.dev.eventify.ui.components.IconBackButton
import com.dev.eventify.ui.components.ImageFit
import com.dev.eventify.ui.components.MediumSpace
import com.dev.eventify.ui.components.ScrollableColumn
import com.dev.eventify.ui.components.SimpleButton
import com.dev.eventify.ui.components.SubTitleText
import com.dev.eventify.ui.components.TopStartColumn
import com.dev.eventify.ui.themes.DARK_BLUE
import com.dev.eventify.ui.themes.GRA_HOR_BLUE_PURPLE
import com.dev.eventify.ui.themes.md_theme_light_primary
import com.dev.eventify.ui.themes.md_theme_light_tertiary

@Composable
fun SelectionScreenView(
    navigateToRegisterProfessor: () -> Unit,
    navigateToRegisterStudent: () -> Unit,
    navigateBack: () -> Unit,
) {
    var selectedRole by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        ScrollableColumn {
            TopStartColumn {
                IconBackButton(onClick = { navigateBack.invoke() },
                    color = DARK_BLUE)
            }

            GapColumn(
                modifier =
                    Modifier
                        .padding(
                            vertical = dimensionResource(id = R.dimen.padding_none),
                            horizontal = dimensionResource(id = R.dimen.padding_medium),
                        ),
            ) {

                ExtraHugeSpace()

                ImageFit(
                    R.drawable.learning_sheep, // Replace with your actual image resource
                    dimensionResource(id = R.dimen.icon_onboard),
                )

                MediumSpace()

                GradientTitleText(
                    text = stringResource(R.string.title_activity_selection),
                    gradient = GRA_HOR_BLUE_PURPLE,
                )

                SubTitleText(text = stringResource(R.string.selection_text))

                ExtraHugeSpace()

            }
            GapRow {
                SimpleButton(
                    text = stringResource(id = R.string.action_professor),
                    color = md_theme_light_primary,
                    onClick = {
                        navigateToRegisterProfessor.invoke()
                    },
                )

                SimpleButton(
                    text = stringResource(id = R.string.action_students),
                    color = md_theme_light_tertiary,
                    onClick = {
                        navigateToRegisterStudent.invoke()
                    },
                )
            }

            HugeSpace()
        }
    }
}

//@Composable
//fun RoleSelectionButton(role: String, selectedRole: String, onRoleSelected: (String) -> Unit) {
//    Button(
//        onClick = { onRoleSelected(role) },
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = if (selectedRole == role) Color.Blue else Color.LightGray
//        ),
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Text(text = role, color = Color.White)
//    }
//}

@Preview
@Composable
fun SelectionScreenPreview(){
    SelectionScreenView(
        navigateToRegisterProfessor = { },
        navigateToRegisterStudent = { },
        navigateBack = {}
    )
}
