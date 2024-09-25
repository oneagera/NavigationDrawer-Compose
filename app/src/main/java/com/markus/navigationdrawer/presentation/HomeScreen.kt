package com.markus.navigationdrawer.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.markus.navigationdrawer.presentation.components.CardItem
import com.markus.navigationdrawer.presentation.components.ModalNavigationDrawer
import com.markus.navigationdrawer.presentation.components.Scaffold
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    val snackbarHostState = remember { SnackbarHostState() }

    ModalNavigationDrawer(
        navController = navController,
        scope = scope,
        drawerState = drawerState,
        content = {
            Scaffold(
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                scope = scope,
                drawerState = drawerState,
                title = "Home",
                content = { paddingValues ->
                    LazyColumn(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        item {
                            for (item in 1..50) {
                                CardItem(snackbarHostState = snackbarHostState)
                            }
                        }
                    }
                }
            )
        }
    )
}