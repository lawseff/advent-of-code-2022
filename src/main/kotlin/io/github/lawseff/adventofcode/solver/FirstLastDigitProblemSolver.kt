package io.github.lawseff.adventofcode.solver

import io.github.lawseff.adventofcode.Day
import io.github.lawseff.adventofcode.PartOne
import io.github.lawseff.adventofcode.PartTwo
import io.github.lawseff.adventofcode.substring.NumberBuilder

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
