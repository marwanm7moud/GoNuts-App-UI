package com.example.godonut.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DonutImage(height:Int , width:Int, modifier: Modifier = Modifier , drawable:Int){
    Image(
        alignment= Alignment.Center,
        modifier = modifier.height(height.dp).width(width.dp),
        painter = painterResource(
            id = drawable
        ),
        contentDescription = "Image",
        contentScale = ContentScale.Fit
    )
}

