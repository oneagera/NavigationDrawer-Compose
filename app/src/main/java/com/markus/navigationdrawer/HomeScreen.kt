package com.markus.navigationdrawer

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.markus.navigationdrawer.components.ModalNavigationDrawer
import kotlinx.coroutines.launch
import com.markus.navigationdrawer.components.Scaffold
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
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
                navController = navController,
                scope = scope,
                drawerState = drawerState,
                title = "Home",
                content = { paddingValues ->
                    LazyColumn(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        item {
                            for (item in 1..50) {
                                CardItem()
                            }
                        }
                    }
                }
            )
        }
    )
}