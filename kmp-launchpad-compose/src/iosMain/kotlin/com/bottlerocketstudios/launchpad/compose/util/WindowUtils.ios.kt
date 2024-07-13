package com.sheltek.kwikstart.compose.util

import com.sheltek.kwikstart.compose.navigation.utils.WindowWidthSizeClass
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIWindow

@OptIn(ExperimentalForeignApi::class)
fun UIWindow.getWindowWidthSizeClass() =
    when (bounds.size) {
        in 840..Int.MAX_VALUE -> WindowWidthSizeClass.Expanded
        in 600..840 -> WindowWidthSizeClass.Medium
        in Int.MIN_VALUE..600 -> WindowWidthSizeClass.Compact
        else -> WindowWidthSizeClass.Medium
    }