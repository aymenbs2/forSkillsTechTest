package com.forSkillsTechTest.movies.ui.molecule


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale


import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.forSkillsTechTest.movies.BuildConfig
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.ui.atom.Rating


@Composable
fun MovieItem(
    movie: Movie,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .height(150.dp)
            .clickable(onClick = onClick),
        elevation = 1.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp),
                model = "${BuildConfig.IMAGES_BASE_URL}${movie.posterPath}",
                contentScale = ContentScale.FillHeight,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = movie.title ?: "",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Rating(movie)

            }

        }
    }
}




