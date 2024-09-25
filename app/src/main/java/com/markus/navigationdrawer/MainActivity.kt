package com.markus.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.markus.navigationdrawer.ui.theme.NavigationDrawerTheme
import androidx.navigation.compose.rememberNavController
import com.markus.navigationdrawer.presentation.HomeScreen
import com.markus.navigationdrawer.presentation.SettingsScreen
import com.markus.navigationdrawer.presentation.UrgentScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(
                                navController = navController,
                                scope = scope,
                                drawerState = drawerState
                            )
                        }
                        composable(route = Screen.UrgentScreen.route) {
                            UrgentScreen(
                                navController = navController,
                                scope = scope,
                                drawerState = drawerState
                            )
                        }
                        composable(route = Screen.SettingsScreen.route) {
                            SettingsScreen(
                                navController,
                                scope,
                                drawerState
                            )
                        }
                    }
                }
            }
        }
    }
}

