package com.markus.navigationdrawer

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object SettingsScreen: Screen("settings_screen")
}