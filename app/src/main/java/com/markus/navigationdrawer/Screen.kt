package com.markus.navigationdrawer

sealed class Screen(val route: String) {
    data object HomeScreen: Screen("home_screen")
    data object UrgentScreen: Screen("urgent_screen")
    data object SettingsScreen: Screen("settings_screen")
}