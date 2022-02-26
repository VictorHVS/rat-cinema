package com.victorhvs.ratcinema.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.victorhvs.ratcinema.R

private val RobotoMono = FontFamily(
    Font(R.font.roboto_mono_light, FontWeight.W300),
    Font(R.font.roboto_mono_regular, FontWeight.W400),
    Font(R.font.roboto_mono_medium, FontWeight.W500),
    Font(R.font.roboto_mono_bold, FontWeight.W600)
)

val RobotoMonoTypography = Typography(
    h1 = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W500,
        fontSize = 32.sp,
    ),
    h2 = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W500,
        fontSize = 26.sp,
    ),
    h3 = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W500,
        fontSize = 22.sp,
    ),
    h4 = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp,
    ),
    h5 = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp,
    ),
    h6 = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W500,
        fontSize = 15.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = RobotoMono,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        color = Color.White
    ),
    caption = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),
    overline = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.W400,
        fontSize = 13.sp
    )
)