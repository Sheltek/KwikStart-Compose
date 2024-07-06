package com.sheltek.kwikstart.compose.navigation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sheltek.kwikstart.compose.navigation.utils.NavigationItem
import com.sheltek.kwikstart.compose.navigation.utils.ToNavigationBarItems

@Composable
fun KwikStartBottomAppBar(
    navItems: List<NavigationItem>,
    isSelected: (String) -> Boolean
) {
    NavigationBar(
        Modifier
            .fillMaxWidth()
    ) {
        ToNavigationBarItems(navItems, isSelected)
    }
}
