package com.dev.eventify.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.zIndex
import com.dev.eventify.R

@Composable
fun GapColumn(modifier: Modifier, content: @Composable (ColumnScope.() -> Unit)){
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.gap_small)),
        content = content
    )
}

@Composable
fun ScrollableColumn(content: @Composable (ColumnScope.() ->Unit)){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

@Composable
fun TopStartColumn(content: @Composable ColumnScope.() -> Unit){

    val zIndex = 3f

    Column(modifier = Modifier
        .padding(dimensionResource(id = R.dimen.padding_medium))
        .zIndex(zIndex)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        content = content
    )
}

@Composable
fun GapRow(content: @Composable RowScope.() -> Unit){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom,
        content = content
    )
}