package com.example.eventify.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.eventify.R

@Composable
fun SmallSpace(){
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_gap)))
}

@Composable
fun MediumSpace(){
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.medium_gap)))
}

@Composable
fun LargeSpace(){
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.large_gap)))
}

@Composable
fun HugeSpace(){
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.huge_gap)))
}

