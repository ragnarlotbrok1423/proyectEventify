package com.dev.eventify.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.eventify.R
import com.dev.eventify.entities.models.getListOfFacultades
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.LIGHT_PURPLE
import com.dev.eventify.ui.viewModels.FacultadesViewModel

////////////////////
//TextField

@Composable
fun GradientTextField(
    label: String,
    placeholder: String,
    icons : ImageVector,
    inputType: KeyboardType,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    isError: Boolean = false,
    errorText: String = "",
    imeAction: ImeAction = ImeAction.Next
) {
//    var text by remember { mutableStateOf("") }

    return TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = icons,
                contentDescription = null
            ) },
        trailingIcon = {
            if (value.isNotBlank()) {
                IconButton(onClick = { onValueChange("") }) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "clear",
                        tint = LIGHT_PURPLE
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = inputType,
            imeAction = imeAction
        ),
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        modifier = Modifier
            .roundedShadow(MaterialTheme.shapes.extraSmall)
            .gradientBlueBg(),
        colors = TextInputColors,
        shape = MaterialTheme.shapes.extraSmall,
        isError = isError,
        supportingText = {
            if (isError) {
                ErrorTextField(text = errorText)
            }
        }
    )
}

@Composable
fun GradientEmailTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isError: Boolean = false,
    errorText: String = "",
    imeAction: ImeAction = ImeAction.Next
) {

    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = imeAction
        ),
        isError = isError,
        supportingText = {
            if (isError) {
                ErrorTextField(text = errorText)
            }
        }
    )

}

@Composable
fun GradientPasswordField(
    label: String,
    placeholder: String,
    icons : ImageVector,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    isError: Boolean = false,
    errorText: String = "",
    imeAction: ImeAction = ImeAction.Done
) {

//    var password by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }

    return TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = icons,
                contentDescription = null
            ) },
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Rounded.Visibility
            else Icons.Rounded.VisibilityOff

            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description, tint = LIGHT_PURPLE)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        modifier = Modifier
            .roundedShadow(MaterialTheme.shapes.extraSmall)
            .gradientBlueBg(),
        colors = TextInputColors,
        shape = MaterialTheme.shapes.extraSmall,
        visualTransformation =
            if (passwordVisible)
                    VisualTransformation.None
            else
                PasswordVisualTransformation(),
        isError = isError,
        supportingText = {
            if (isError) {
                ErrorTextField(text = errorText)
            }
        }
    )
}

@Composable
fun GradientPhoneTextField(
    value: String = "",
    onValueChange: (String) -> Unit = {},
    isError: Boolean = false,
    errorText: String = "",
    imeAction: ImeAction = ImeAction.Next
) {
//    var phoneNumber by rememberSaveable { mutableStateOf("") }
    val numericRegex = Regex("[^0-9]")
    TextField(
        value = value,
        onValueChange = {
            var number = onValueChange.toString()
            val stripped = numericRegex.replace(it, "")
            number = if (stripped.length >= 10) {
                stripped.substring(0..9)
            } else {
                stripped
            }
        },
        label = { Text(stringResource(id = R.string.prompt_phone)) },
        visualTransformation = NanpVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = imeAction
        ),
        modifier = Modifier
            .roundedShadow(MaterialTheme.shapes.extraSmall)
            .gradientBlueBg(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = null
            )
        },
        trailingIcon = {
            if (value.isNotBlank()) {
                IconButton(onClick = { onValueChange("") }) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "clear",
                        tint = LIGHT_PURPLE
                    )
                }
            }
        },
        colors = TextInputColors,
        shape = MaterialTheme.shapes.extraSmall,
        isError = isError,
        supportingText = {
            if (isError) {
                ErrorTextField(text = errorText)
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FacultySelectTextField(
    label: String,
    facultadesViewModel: FacultadesViewModel = viewModel(),
    value: String = "",
    onValueChange: (String) -> Unit = {},
){

    var expanded by remember { mutableStateOf(false) }

    // si lista en kotlin
    val options = getListOfFacultades()
    var selectedOptionText by remember { mutableStateOf(options[0].nombreFacultad) }

    // si lista en get
//    val options by facultadesViewModel.facultades.observeAsState(emptyList())
//    var selectedOptionText by remember { mutableStateOf("") }

//    var options by remember { mutableStateOf(listOf<Facultades>()) }
//    var selectedOptionText by remember { mutableStateOf("") }

//    LaunchedEffect(Unit) {
//        fetchFacultades { fetchedFacultades ->
//            options = fetchedFacultades
//        }
//    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },

        ) {
         OutlinedTextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { selectedOptionText = it },
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = OutlinedTextInputColors,
            modifier = Modifier
//                .roundedShadow(MaterialTheme.shapes.extraSmall)
                .transparentBg()
                .menuAnchor(),
            shape = MaterialTheme.shapes.extraSmall,
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier = Modifier.exposedDropdownSize(true),
            scrollState = rememberScrollState()
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(text = selectionOption.nombreFacultad) },
                    onClick = {
                        selectedOptionText = selectionOption.nombreFacultad
                        expanded = false
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun TextFieldComponentPreview(){
    EventifyTheme(darkTheme = false){

        GapColumn(modifier = Modifier.
        padding(vertical = dimensionResource(id = R.dimen.padding_none),
            horizontal = dimensionResource(id = R.dimen.padding_medium),
        ),) {

            GradientTextField(
                "Username",
                "Enter your username",
                Icons.Default.Email,
                KeyboardType.Text,
            )

            GradientPasswordField(
                "Username",
                "Enter your username",
                Icons.Rounded.Lock,
            )

            GradientPhoneTextField()

            FacultySelectTextField("level")

            GradientEmailTextField(label = "email",
                value =  "",
                onValueChange = { (String) },
                modifier = Modifier.fillMaxWidth())
        }
    }
}
