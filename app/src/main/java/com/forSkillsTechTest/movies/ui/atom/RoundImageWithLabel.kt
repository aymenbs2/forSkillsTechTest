package com.forSkillsTechTest.movies.ui.atom

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun RoundImageWithLabel(imagePath: String, label: String) {
    Column(Modifier.padding(10.dp)) {
        AsyncImage(
            modifier = Modifier
                .size(90.dp).clip(CircleShape),
            model = imagePath,
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = label)
    }
}