package com.bottlerocketstudios.launchpad.compose.util

import platform.Foundation.NSLocale
import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterCurrencyStyle
import platform.Foundation.currentLocale
import platform.Foundation.numberWithDouble

actual fun Double?.toCurrency(): String {
    val formatter = NSNumberFormatter()
    formatter.numberStyle = NSNumberFormatterCurrencyStyle
    formatter.locale = NSLocale.currentLocale()

    val number = NSNumber.numberWithDouble(this ?: 0.0)
    return formatter.stringFromNumber(number) ?: "NaN"
}
