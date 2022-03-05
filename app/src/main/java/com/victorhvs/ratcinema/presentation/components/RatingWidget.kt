package com.victorhvs.ratcinema.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.RatingBar
import com.victorhvs.ratcinema.ui.theme.SMALL_PADDING
import com.victorhvs.ratcinema.ui.theme.ratingBarActive
import com.victorhvs.ratcinema.ui.theme.ratingBarInactive

@Composable
fun MovieRating(stars: Float = 0f, votes: Int = 0) {
    Row(
        modifier = Modifier.padding(top = SMALL_PADDING),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RatingBar(
            value = stars,
            onValueChange = {},
            onRatingChanged = {},
            isIndicator = true,
            numStars = 5,
            size = 12.dp,
            activeColor = ratingBarActive,
            inactiveColor = ratingBarInactive,
            modifier = Modifier.padding(end = SMALL_PADDING)
        )
        Text(
            text = "(${votes} votes)",
            textAlign = TextAlign.Center,
            color = Color.White.copy(alpha = ContentAlpha.medium)
        )
    }
}