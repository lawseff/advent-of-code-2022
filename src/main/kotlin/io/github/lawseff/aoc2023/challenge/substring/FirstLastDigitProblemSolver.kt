package io.github.lawseff.aoc2023.challenge.substring

import io.github.lawseff.aoc2023.Day
import io.github.lawseff.aoc2023.PartOne
import io.github.lawseff.aoc2023.PartTwo

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
