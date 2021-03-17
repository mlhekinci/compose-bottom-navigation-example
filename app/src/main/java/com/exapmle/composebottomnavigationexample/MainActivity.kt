package com.exapmle.composebottomnavigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.exapmle.composebottomnavigationexample.screens.BottomNavigationScreen
import com.exapmle.composebottomnavigationexample.screens.Screens
import com.exapmle.composebottomnavigationexample.ui.theme.ComposeBottomNavigationExampleTheme

class MainActivity : ComponentActivity() {

    private val bottomNavigationItems = listOf(
        BottomNavigationScreen.Home,
        BottomNavigationScreen.Trend,
        BottomNavigationScreen.Search,
        BottomNavigationScreen.Setting,
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomNavigationExampleTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        ScreenBottomNavigation(navController, bottomNavigationItems)
                    },
                ) {
                    ScreenNavController(navController)
                }
            }
        }
    }

    @Composable
    fun ScreenBottomNavigation(navController: NavHostController, items: List<BottomNavigationScreen>) {
        BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

            items.forEach {
                BottomNavigationItem(
                    icon = { Icon(imageVector = it.icon, contentDescription = it.title)},
                    selected = currentRoute == it.route,
                    label = { Text(text = it.title) },
                    onClick = {
                        navController.popBackStack(
                            navController.graph.startDestination, false
                        )
                        if (currentRoute != it.route) {
                            navController.navigate(it.route)
                        }
                    })
            }
        }
    }

    @Composable
    fun ScreenNavController(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "home") {
            val screens = Screens()
            composable(BottomNavigationScreen.Home.route) {
                screens.HomeScreen()
            }

            composable(BottomNavigationScreen.Trend.route) {
                screens.TrendScreen()
            }

            composable(BottomNavigationScreen.Search.route) {
                screens.SearchScreen()
            }

            composable(BottomNavigationScreen.Setting.route) {
                screens.SettingsScreen()
            }
        }
    }
}