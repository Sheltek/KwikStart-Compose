package com.sheltek.kwikstart.compose.navigation.components

import androidx.compose.material3.NavigationRail
import androidx.compose.runtime.Composable
import com.sheltek.kwikstart.compose.navigation.utils.NavigationItem
import com.sheltek.kwikstart.compose.navigation.utils.toNavigationRailItems

@Composable
fun LaunchpadNavigationRail(navItems: List<NavigationItem>, isSelected: (String) -> Boolean) {
    NavigationRail {
        navItems.toNavigationRailItems(isSelected)
    }
}
