package com.markus.navigationdrawer.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.markus.navigationdrawer.Screen
import com.markus.navigationdrawer.presentation.components.ModalNavigationDrawer
import com.markus.navigationdrawer.presentation.components.Scaffold
import kotlinx.coroutines.CoroutineScope

@Composable
fun SettingsScreen(
    navController: NavController,
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    ModalNavigationDrawer(
        navController = navController,
        scope = scope,
        drawerState = drawerState,
        content = {
            Scaffold(
                snackbarHost = { },
                scope = scope,
                drawerState = drawerState,
                title = "Settings"
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            navController.navigate(route = Screen.HomeScreen.route)
                        }
                    ) {
                        Text(text = "Nav To Home Screen")
                    }
                }
            }
        }
    )
}