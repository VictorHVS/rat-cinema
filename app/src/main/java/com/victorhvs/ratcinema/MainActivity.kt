package com.victorhvs.ratcinema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.victorhvs.ratcinema.navigation.SetupNavGraph
import com.victorhvs.ratcinema.ui.theme.RatCinemaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RatCinemaTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}