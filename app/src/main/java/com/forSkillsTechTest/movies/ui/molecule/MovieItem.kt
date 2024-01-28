package com.forSkillsTechTest.movies.ui.molecule


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Star


import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.forSkillsTechTest.movies.BuildConfig
import com.forSkillsTechTest.movies.R
import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.ui.atom.Rating
import com.forSkillsTechTest.movies.ui.theme.Gold


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
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
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
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(240.dp)) {
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
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.ic_forward_arrow_icon),
                modifier = Modifier.align(Alignment.CenterVertically).size(25.dp),
                contentDescription =null
            )

        }
    }
}




