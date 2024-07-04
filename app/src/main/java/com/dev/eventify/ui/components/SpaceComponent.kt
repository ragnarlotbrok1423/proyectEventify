package com.dev.eventify.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.dev.eventify.R

@Composable
fun SmallSpace(){
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.gap_small)))
}

@Composable
fun MediumSpace(){
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.gap_medium)))
}

@Composable
fun LargeSpace(){
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.gap_large)))
}

@Composable
fun HugeSpace(){
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.gap_huge)))
}

