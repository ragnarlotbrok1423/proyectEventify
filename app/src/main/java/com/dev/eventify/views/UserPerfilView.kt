package com.dev.eventify.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.eventify.R
import com.dev.eventify.ui.themes.Shape
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip


@Composable
fun PerfilView(){
    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        color = colorResource(id = R.color.purple_darker), // Replace with your actual background color or drawable
                        shape = Shape.small // Adjust corner radius as needed
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Handle back button click */ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Use appropriate arrow icon
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = "Comentarios",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 18.sp
                )
                IconButton(onClick = { /* Handle profile click */ }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.splash_icon), // Replace with your actual drawable
//                        contentDescription = "Profile"
//                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    // User details (name, faculty, market info) - use Text composables
                }
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .background(Color.Green) // Replace with actual background
                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.splash_icon),
//                        contentDescription = "Profile Picture",
//                        modifier = Modifier.fillMaxSize(),
//                        contentScale = ContentScale.Crop
//                    )
                    Button(
                        onClick = { /* Handle follow button click */ },
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .offset(y = (-30).dp), // Adjust offset as needed
                        colors = ButtonDefaults.buttonColors(Color(0xFF6750A4))
                    ) {
                        Text("Follow", color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun perfilPreview(){
    PerfilView()
}
