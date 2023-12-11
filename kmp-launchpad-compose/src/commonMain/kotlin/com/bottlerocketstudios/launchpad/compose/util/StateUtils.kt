@file:Suppress("unused")

package com.bottlerocketstudios.launchpad.compose.util

import androidx.compose.runtime.mutableStateOf

fun <T> T.asMutableState() = mutableStateOf(this)
