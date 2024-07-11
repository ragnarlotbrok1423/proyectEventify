package com.dev.eventify.ui.views.authenticated

import android.view.LayoutInflater
import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.dev.eventify.R

@Composable
fun UserProfileView(
    navigateToUnauthenticatedRoute: () -> Unit,
    navigateBack: () -> Unit,
) {
    AndroidView(
        factory = { context ->
            LayoutInflater.from(context).inflate(R.layout.user_profile, null)
        },
        update = { view ->
            // Handle view updates and set onClickListeners if necessary
            val button = view.findViewById<ImageButton>(R.id.quitButton)
            button.setOnClickListener {
                // Navigate to another screen
                navigateToUnauthenticatedRoute.invoke()
            }
        }
    )
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
    UserProfileView(
        navigateToUnauthenticatedRoute = {},
    ){}
}
