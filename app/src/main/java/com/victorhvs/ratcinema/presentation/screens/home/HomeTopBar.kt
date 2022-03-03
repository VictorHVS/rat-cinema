package com.victorhvs.ratcinema.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.victorhvs.ratcinema.R
import com.victorhvs.ratcinema.util.Constants.PRAVATAR_URL

@Composable
fun HomeTopBar(onSearchClicked: () -> Unit, onProfileClicked: () -> Unit) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.ic_rat_cinema_icon),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier.size(44.dp)
            )
        },
        elevation = 0.dp,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
            IconButton(
                onClick = onProfileClicked
            ) {
                val painter = rememberImagePainter(data = PRAVATAR_URL)
                Image(
                    painter = painter,
                    contentDescription = stringResource(id = R.string.avatar_user),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(percent = 10))
                )
            }
        }
    )
}

@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar(
        onSearchClicked = {},
        onProfileClicked = {}
    )
}
