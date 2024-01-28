package com.forSkillsTechTest.movies.ui.molecule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.forSkillsTechTest.movies.BuildConfig
import com.forSkillsTechTest.movies.R
import com.forSkillsTechTest.movies.domain.model.Cast
import com.forSkillsTechTest.movies.ui.atom.RoundImageWithLabel

@Composable
fun Actors(castsState: State<List<Cast>>, modifier: Modifier = Modifier) {
    Column(modifier){
        Text(text =  stringResource(id = R.string.cast), style = MaterialTheme.typography.h5 )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow {
            items(castsState.value.take(5)) { cast ->
                RoundImageWithLabel(imagePath = "${BuildConfig.IMAGES_BASE_URL}${cast.profilePath}", label =cast.name?:"" )
            }
        }
    }

}
