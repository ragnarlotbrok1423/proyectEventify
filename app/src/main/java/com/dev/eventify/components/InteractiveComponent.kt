package com.dev.eventify.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.eventify.R
import com.dev.eventify.models.facultyModel
import com.dev.eventify.ui.themes.BLACK
import com.dev.eventify.ui.themes.DARKER_BLUE
import com.dev.eventify.ui.themes.EventifyTheme
import com.dev.eventify.ui.themes.GRA_HOR_BLACK_PURPLE
import com.dev.eventify.ui.themes.GRA_HOR_BLUE_PURPLE
import com.dev.eventify.ui.themes.Shape


////////////////////
// Button

@Composable
fun GradientButton(
    onClick: () -> Unit = { },
    text: String,
    gradient : Brush,
    ){
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .background(gradient, MaterialTheme.shapes.extraLarge)
                .border(0.dp, Color.Transparent, MaterialTheme.shapes.extraLarge)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = MaterialTheme.shapes.extraLarge
        ){
            CustomContextText(text = text.uppercase(),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
            )
        }
}

@Composable
fun OutlineButton(
    onClick: () -> Unit ={},
    text: String,
    ) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .background(Color.Transparent, shape = MaterialTheme.shapes.extraLarge)
            .border(2.dp, brush = GRA_HOR_BLACK_PURPLE, shape = MaterialTheme.shapes.extraLarge)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = MaterialTheme.shapes.extraLarge
    ){
        CustomContextText(text = text.uppercase(),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
        )
    }
}

////////////////////
//TextField

@Composable
fun Modifier.gradientBlueBg(): Modifier{
    return this then Modifier
        .background(GRA_HOR_BLUE_PURPLE, shape = MaterialTheme.shapes.small)
        .fillMaxWidth()
}

@Composable
fun GradientTextFieldWithIcons(
    label: String,
    placeholder: String,
    icons :ImageVector,
    inputType: KeyboardType,
) {
    var text by remember { mutableStateOf("") }

    return TextField(
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = icons,
                contentDescription = null
            ) },
        trailingIcon = {
            if (text.isNotBlank()) {
                IconButton(onClick = { text = "" }) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "clear",
                        tint = DARKER_BLUE
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = inputType),
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        modifier = Modifier.gradientBlueBg(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor =Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedTextColor = BLACK,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedLabelColor = colorResource(R.color.purple_dark),
            focusedLabelColor = BLACK,
            ),
        shape = Shape.small,

    )
}

@Composable
fun GradientPasswordField(
    label: String,
    placeholder: String,
    icons :ImageVector,
) {

    // Creating a variable to store password
    var password by remember { mutableStateOf("") }

    // Creating a variable to store toggle state
    var passwordVisible by remember { mutableStateOf(false) }

    return TextField(
        value = password,
        onValueChange = {
            password = it
        },
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

            // Localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            // Toggle button to hide or display password
            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description, tint = DARKER_BLUE)
            }
                       },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        modifier = Modifier.gradientBlueBg(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor =Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedTextColor = BLACK,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedLabelColor = colorResource(R.color.purple_darker),
            focusedLabelColor = BLACK
        ),
        shape = Shape.small
        )
}

@Composable
fun GradientPhoneTextField() {
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    val numericRegex = Regex("[^0-9]")
    TextField(
        value = phoneNumber,
        onValueChange = {
            // Quitar los que no son numeros
            val stripped = numericRegex.replace(it, "")
            phoneNumber = if (stripped.length >= 10) {
                stripped.substring(0..9)
            } else {
                stripped
            }
        },
        label = { Text(stringResource(id = R.string.prompt_phone)) },
        visualTransformation = NanpVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.gradientBlueBg(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = null
            )
                      },
        trailingIcon = {
            if (phoneNumber.isNotBlank()) {
                IconButton(onClick = { phoneNumber = "" }) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "clear",
                        tint = DARKER_BLUE
                    )
                }
            }
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor =Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedTextColor = BLACK,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedLabelColor = colorResource(R.color.purple_darker),
            focusedLabelColor = BLACK
        ),
        shape = Shape.small
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectTextField(label: String){
    val options = facultyModel
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },

    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier= Modifier.exposedDropdownSize(true),
            scrollState = rememberScrollState()
            ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(text = selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                )
            }
        }
    }
}

@Preview()
@Composable
fun ComponentPreiew(){
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

            SmallSpace()

            GradientTextFieldWithIcons(
                "Username",
                "Enter your username",
                Icons.Default.Email,
                KeyboardType.Text,
                )

            SmallSpace()

            GradientPasswordField(
                "Username",
                "Enter your username",
                Icons.Rounded.Lock,
            )

            SmallSpace()

            GradientPhoneTextField()

            SmallSpace()

            SelectTextField("level")

        }
    }
}
