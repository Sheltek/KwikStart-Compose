package com.sheltek.kwikstart.compose.widget.listdetail

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sheltek.kwikstart.compose.util.LaunchCollection
import com.sheltek.kwikstart.compose.widgets.listdetail.ListDetailScope
import com.sheltek.kwikstart.compose.widgets.listdetail.ListDetailScopeImpl

// Internal  Routes for use by this widget
internal sealed class Route(val route: String) {
    object Detail : Route("detail/{selected}") {
        fun navigateRoute(selected: String?) = "detail/$selected"
    }
}

/**
 * Animated list detail - Composable that creates an animated list/detail UI
 *
 * @param T - Type for list items and detail
 * @param list - list of [T] items
 * @param compactWidth - Is display small screen form factor
 * @param keyProvider - Code block used to provide selection key from [T]
 * @param scope - [ListDetailScope] provides UI definition for List and Detail, along with callbacks.
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun <T> AnimatedListDetail(
    list: List<T>,
    compactWidth: Boolean,
    keyProvider: (T) -> String = { it.toString() },
    scope: @Composable ListDetailScope<T>.() -> Unit
) {
    val navController = rememberNavController()
    val listDetailScope = ListDetailScopeImpl(list).apply { scope() }

    // UI for showing one screen at a time
    @Composable
    fun ListDetailScopeImpl<T>.singleScreen(selected: T?) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Show detail if item is selected
            selected?.also {
                detail(it)
            } ?: run {
                // Otherwise, show list
                list(items)
            }
        }
    }

    // UI for large screens, display both list and detail
    @Composable
    fun ListDetailScopeImpl<T>.sideBySideScreens(selected: T?) {
        Row(Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.weight(1f)) {
                list(items)
            }
            Box(modifier = Modifier.weight(1f)) {
                detail(selected)
            }
        }
    }

    NavHost(navController = navController, startDestination = Route.Detail.route) {
        composable(
            route = Route.Detail.route
        ) { backStackEntry ->
            val selectedKey = backStackEntry.arguments?.getString("selected")
            val selected: T? = list.find { keyProvider(it) == selectedKey }
            listDetailScope.detailStateCallback(selected != null)

            // Use scoped selector to allow outside selection
            listDetailScope.selector.LaunchCollection { selectionKey ->
                navController.navigate(route = Route.Detail.navigateRoute(selectionKey)) {
                    popUpTo(Route.Detail.navigateRoute(null)) {
                        inclusive = true
                    }
                }
            }

            // Switch UI on screen size
            if (compactWidth) {
                listDetailScope.singleScreen(selected)

                // Only intercept back presses if an item is selected. This allows outside nav host to handle backs.
                BackHandler(selected != null) {
                    navController.popBackStack()
                }
            } else {
                listDetailScope.sideBySideScreens(selected = selected)
            }
        }
    }
}
