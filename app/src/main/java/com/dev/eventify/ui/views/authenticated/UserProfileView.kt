package com.dev.eventify.ui.views.authenticated

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Brush
import com.dev.eventify.R

@Composable
fun UserProfileView(
    navigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Profile Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color(0xFFE0F7FA), RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Mi perfil",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

        // User Info
        Column(
            modifier = Modifier.padding(bottom = 16.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Picture
            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login_sheep),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(100.dp)
                        .background(
                            Brush.radialGradient(
                                colors = listOf(Color.Green, Color.Transparent),
                                radius = 50f
                            ),
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )
                Button(
                    onClick = { /* Edit Profile Picture */ },
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.LightGray, shape = CircleShape)
                ) {
                    Text("Editar")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Helena 19", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "Facultad de Sistemas Computacionales",
                fontSize = 16.sp,
                color = Color.Gray
            )
            Text(
                text = "Market Helen S.A.\nVenta de producto de software",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        // Communities
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Comunidades",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Communities Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(8.dp),
                content = {
                    items(9) { index ->
                        CommunityItem(index)
                    }
                }
            )
        }
    }
}

@Composable
fun CommunityItem(index: Int) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .background(Color.LightGray, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Community $index")
    }
}

@Preview
@Composable
fun UserProfilePreview() {
    UserProfileView(){}
}
