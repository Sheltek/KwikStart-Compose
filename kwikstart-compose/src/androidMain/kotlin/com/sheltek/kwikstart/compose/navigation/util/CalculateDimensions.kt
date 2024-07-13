package com.sheltek.kwikstart.compose.navigation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.sheltek.kwikstart.compose.resources.Dimensions
import com.sheltek.kwikstart.compose.resources.SMALL_SCREEN_WIDTH_DP
import com.sheltek.kwikstart.compose.resources.smallDimensions
import com.sheltek.kwikstart.compose.resources.sw360Dimensions

/**
 * Returns the dimensions of the screen.
 *
 * If the screen width is less than or equal to 360dp, the small dimensions are returned.
 * Otherwise, the sw360 dimensions are returned.
 */
@Composable
fun getDimensions(): Dimensions = if (LocalConfiguration.current.screenWidthDp <= SMALL_SCREEN_WIDTH_DP) smallDimensions else sw360Dimensions
