package io.github.lawseff.adventofcode.challenge.substring

import io.github.lawseff.adventofcode.Day
import io.github.lawseff.adventofcode.PartOne
import io.github.lawseff.adventofcode.PartTwo

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
