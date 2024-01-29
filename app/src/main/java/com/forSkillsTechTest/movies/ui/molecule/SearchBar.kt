package com.forSkillsTechTest.movies.ui.molecule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.forSkillsTechTest.movies.R
import com.forSkillsTechTest.movies.ui.theme.Blue
import com.forSkillsTechTest.movies.ui.theme.Gray200


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    isFocused: MutableState<Boolean>,
    onQueryChange: (String) -> Unit,
    onFocusChange: (Boolean) -> Unit,

    ) {
    val query = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Row (modifier = modifier){
        TextField(
            modifier = Modifier
                .weight(0.6f)
                .padding(10.dp)
                .background(Gray200, RoundedCornerShape(10.dp))
                .height(50.dp)
                .focusable(true)
                .onFocusChanged {
                    isFocused.value = it.hasFocus
                    onFocusChange(it.isFocused)
                },
            value = query.value,
            placeholder = {
                Row {
                    Image(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                    )
                    Text(
                        text = stringResource(id = R.string.search)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black,
                disabledLabelColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                query.value = it
                onQueryChange(it)
            },
            trailingIcon = {
                if (isFocused.value && query.value.isNotBlank()) {
                    IconButton(
                        onClick = {
                            query.value = ""
                            onQueryChange("")
                        }
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = stringResource(id = R.string.clear)
                        )
                    }
                }
            }
        )
        if (isFocused.value) {
            Text(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .align(Alignment.CenterVertically)
                    .clickable {
                        query.value = ""
                        onQueryChange("")
                        focusManager.clearFocus()
                    },
                text = stringResource(id = R.string.cancel),
                color = Blue
            )
        }

    }

}

