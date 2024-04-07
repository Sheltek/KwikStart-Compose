@file:Suppress("unused")

package com.sheltek.kwikstart.compose.util

import androidx.compose.runtime.mutableStateOf

fun <T> T.asMutableState() = mutableStateOf(this)
