package com.bottlerocketstudios.launchpad.compose.widgets.slidingappbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Sliding app bar
 *
 * @param visible - Controls visibility using sliding in/out animation
 * @param title - same as TopAppBar
 * @param modifier - same as TopAppBar
 * @param navigationIcon - same as TopAppBar
 * @param actions - same as TopAppBar
 * @param backgroundColor - same as TopAppBar
 * @param contentColor - same as TopAppBar
 * @param elevation - same as TopAppBar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SlidingAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(backgroundColor),
    visible: Boolean = true
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = spring(stiffness = Spring.StiffnessHigh)
        ),
        exit = slideOutVertically(
            animationSpec = spring(stiffness = Spring.StiffnessHigh)
        )
    ) {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon,
            actions = actions,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = backgroundColor,
                titleContentColor = contentColor,
                actionIconContentColor = contentColor
            ),
            modifier = modifier
        )
    }
}
