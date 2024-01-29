package com.forSkillsTechTest.movies.ui.atom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.forSkillsTechTest.movies.R

@Composable
fun Synopsis(modifier: Modifier=Modifier,overview: String?) {
    Column (modifier=modifier){
        Text(text = stringResource(id = R.string.synopsis), style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = overview ?: "", textAlign = TextAlign.Left)
    }
}
