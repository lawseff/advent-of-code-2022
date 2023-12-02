package io.github.lawseff.adventofcode.challenge.substring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NumberBuilderTest {

    private val numberBuilder = NumberBuilder()

    @ParameterizedTest(name = "returns {1} from {0}")
    @CsvSource("1abc2,12", "pqr3stu8vwx,38", "a1b2c3d4e5f,15", "treb7uchet,77")
    fun `builds number from first and last digit`(input: String, expectedNumber: Int) {
        val actualNumber = numberBuilder.buildFromFirstLastDigit(input)

        assertEquals(expectedNumber, actualNumber)
    }

    @Test
    fun `throws exception, if input contains no digits`() {
        assertThrows<NoSuchElementException> {
            numberBuilder.buildFromFirstLastDigit("abba")
        }
    }

    @ParameterizedTest(name = "returns {1} from {0}")
    @CsvSource(
        "two1nine,29", "eightwothree,83", "abcone2threexyz,13", "xtwone3four,24",
        "4nineeightseven2,42", "zoneight234,14", "7pqrstsixteen,76",
        "seven,77"
    )
    fun `builds number from first and last digit (numerical or alphabetical)`(input: String, expectedNumber: Int) {
        val actualNumber = numberBuilder.buildFromFirstLastAlphaDigit(input)

        assertEquals(expectedNumber, actualNumber)
    }

    @Test
    fun `throws exception, if input contains no alpha-digits`() {
        assertThrows<NoSuchElementException> {
            numberBuilder.buildFromFirstLastDigit("abba")
        }
    }

}
