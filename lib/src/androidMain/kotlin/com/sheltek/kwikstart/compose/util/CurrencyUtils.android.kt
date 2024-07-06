package com.sheltek.kwikstart.compose.util

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

actual fun Double?.toCurrency(): String {
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.currency = Currency.getInstance(Locale.getDefault())
    return numberFormat.format(this ?: 0.0)
}
