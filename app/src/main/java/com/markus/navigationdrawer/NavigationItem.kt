package com.markus.navigationdrawer

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val onClick: () -> Unit,
    val badgeCount: Int? = null
)
