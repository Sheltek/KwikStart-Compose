package com.sheltek.kwikstart.compose.navigation.components

import androidx.compose.runtime.Composable
import com.sheltek.kwikstart.compose.navigation.utils.NavigationItem
import com.sheltek.kwikstart.compose.navigation.utils.toNavigationDrawerItems

@Composable
fun LaunchpadDrawerContent(navItems: List<NavigationItem>, isSelected: (String) -> Boolean) {
    navItems.toNavigationDrawerItems(isSelected)
}
