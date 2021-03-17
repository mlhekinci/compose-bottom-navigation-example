package com.exapmle.composebottomnavigationexample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


class Screens {

    @Composable
    fun HomeScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Home",
                style = TextStyle(color = Color.White, fontSize = 42.sp)
            )
        }

    }

    @Composable
    fun TrendScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Trends",
                style = TextStyle(color = Color.White, fontSize = 42.sp)
            )
        }
    }

    @Composable
    fun SearchScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Search",
                style = TextStyle(color = Color.White, fontSize = 42.sp)
            )
        }
    }

    @Composable
    fun SettingsScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = "Setting",
                style = TextStyle(color = Color.White, fontSize = 42.sp)
            )
        }
    }
}

sealed class BottomNavigationScreen(val route: String, val title: String, val icon: ImageVector) {
    object Home: BottomNavigationScreen("home", "Home", Icons.Default.Home)
    object Trend: BottomNavigationScreen("trend", "Trends", Icons.Default.Favorite)
    object Search: BottomNavigationScreen("search", "Search", Icons.Default.Search)
    object Setting: BottomNavigationScreen("setting", "Settings", Icons.Default.Settings)
}