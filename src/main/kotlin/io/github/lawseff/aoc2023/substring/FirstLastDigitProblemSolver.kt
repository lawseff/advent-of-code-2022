package io.github.lawseff.aoc2023.substring

import io.github.lawseff.aoclib.Day
import io.github.lawseff.aoclib.PartOne
import io.github.lawseff.aoclib.PartTwo

@Day(1)
class FirstLastDigitProblemSolver {

    private val numberBuilder = NumberBuilder()

    @PartOne
    fun sumNumbersFromFirstLastDigits(input: List<String>): Int {
        return input.sumOf { numberBuilder.buildFromFirstLastDigit(it) }
    }

    @PartTwo
    fun sumNumbersFromFirstLastAlphaDigits(input: List<String>): Int {
        return input.sumOf { numberBuilder.buildFromFirstLastAlphaDigit(it) }
    }

}
