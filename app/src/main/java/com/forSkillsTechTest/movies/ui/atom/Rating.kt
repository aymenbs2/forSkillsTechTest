package com.forSkillsTechTest.movies.ui.atom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import com.forSkillsTechTest.movies.domain.model.Movie
import com.forSkillsTechTest.movies.ui.theme.Gold

@Composable
fun Rating(movie: Movie) {
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            tint = Gold,
            imageVector = Icons.Rounded.Star,
            contentDescription = ""
        )
        Text(
            text = "${movie.voteAverage}",
            style = MaterialTheme.typography.body2,

        )
    }
}