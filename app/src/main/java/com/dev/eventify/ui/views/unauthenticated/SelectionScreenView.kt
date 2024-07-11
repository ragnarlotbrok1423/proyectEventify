package com.dev.eventify.ui.views.unauthenticated

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.dev.eventify.R
import com.dev.eventify.ui.components.GapColumn
import com.dev.eventify.ui.components.ImageFit
import com.dev.eventify.ui.components.ScrollableColumn

@Composable
fun SelectionScreen() {
    var selectedRole by remember { mutableStateOf("") }

    ScrollableColumn {
        GapColumn(
        modifier = Modifier
            .padding(vertical = dimensionResource(id = R.dimen.padding_none),
                horizontal = dimensionResource(id = R.dimen.padding_medium),
            )
    ) {
            ImageFit(
                R.drawable.learning, // Replace with your actual image resource
                modifier = Modifier.size(150.dp),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Keep",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Keep various ways to contact and get in touch easily right from the app",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(32.dp))
            RoleSelectionButton(role = "Student", selectedRole) { selectedRole = it }
            Spacer(modifier = Modifier.height(16.dp))
            RoleSelectionButton(role = "Professor", selectedRole) { selectedRole = it }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /* Handle Start button click */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Let's start", color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Handle Login button click */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = "Log in", color = Color.White)
            }
        }
    }
}

@Composable
fun RoleSelectionButton(role: String, selectedRole: String, onRoleSelected: (String) -> Unit) {
    Button(
        onClick = { onRoleSelected(role) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (selectedRole == role) Color.Blue else Color.LightGray
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = role, color = Color.White)
    }
}