package io.github.lawseff.aoc2023.challenge.substring

import io.github.lawseff.aoc2023.challenge.asInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FirstLastDigitProblemSolverTest {

    private val solver = FirstLastDigitProblemSolver()

    @Test
    fun `should sum numbers, consisting of first and last digit`() {
        val input = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.asInput()

        val sum = solver.sumNumbersFromFirstLastDigits(input)

        assertEquals(142, sum)
    }

    @Test
    fun `should sum numbers, consisting of first and last digit or digit as word`() {
        val input = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.asInput()

        val sum = solver.sumNumbersFromFirstLastAlphaDigits(input)

        assertEquals(281, sum)
    }

}