package com.bottlerocketstudios.launchpad.compose

import com.bottlerocketstudios.launchpad.compose.util.toCurrency
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertEquals


class CurrencyUtilsTest {

    @Test
    fun `test double toCurrency`() {
        Locale.setDefault(Locale.US)

        val input = 1234.56
        val expectedOutput = "$1,234.56"
        val actualOutput = input.toCurrency()

        assertEquals(expectedOutput, actualOutput)
    }
}