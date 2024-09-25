package com.markus.navigationdrawer.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.markus.navigationdrawer.presentation.components.ModalNavigationDrawer
import com.markus.navigationdrawer.presentation.components.Scaffold
import kotlinx.coroutines.CoroutineScope

@Composable
fun UrgentScreen(
    modifier: Modifier = Modifier,
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
                title = "Home",
                content = { paddingValues ->
                    Column(
                        modifier.fillMaxSize().padding(paddingValues),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Urgent Messages",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            )
        }
    )
}