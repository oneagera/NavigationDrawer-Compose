package com.markus.navigationdrawer.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.markus.navigationdrawer.NavigationItem
import com.markus.navigationdrawer.Screen
import kotlinx.coroutines.CoroutineScope

@Composable
fun ModalNavigationDrawer(
    navController: NavController,
    scope: CoroutineScope,
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {
    val items = listOf(
        NavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            onClick = { navController.navigate(Screen.HomeScreen.route) }
        ),
        NavigationItem(
            title = "Urgent",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            badgeCount = 45,
            onClick = { }
        ),
        NavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            onClick = { navController.navigate(Screen.SettingsScreen.route) }
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    ModalNavigationDrawer(
        drawerContent = {
            //Options to ModalNavigationDrawer are: PermanentNavigationDrawer that does not require drawerState & DismissibleNavigationDrawer
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                items.forEachIndexed { index, navigationItem ->
                    NavigationDrawerItem(
                        label = { Text(text = navigationItem.title) },
                        selected = index == selectedItemIndex,
                        onClick = {
                            navigationItem.onClick()
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close() //close our drawer sheet once an item is selected
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    navigationItem.selectedIcon
                                } else navigationItem.unselectedIcon,
                                contentDescription = null
                            )
                        },
                        badge = {
                            navigationItem.badgeCount?.let {
                                Text(text = navigationItem.badgeCount.toString())
                            }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        drawerState = drawerState,
        content = content
    )
}