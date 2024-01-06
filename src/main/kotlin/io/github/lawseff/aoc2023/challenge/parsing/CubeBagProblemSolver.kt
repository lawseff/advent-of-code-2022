package io.github.lawseff.aoc2023.challenge.parsing

import io.github.lawseff.aoc2023.Day
import io.github.lawseff.aoc2023.PartOne
import io.github.lawseff.aoc2023.PartTwo

@Day(2)
class CubeBagProblemSolver {

    companion object {
        const val MAX_RED_COUNT = 12

        const val MAX_GREEN_COUNT = 13

        const val MAX_BLUE_COUNT = 14
    }

    private val parser = CubeGameParser()

    private val calculator = CubeGameCalculator()

    @PartOne
    fun sumGameIdsOfPossibleGames(input: List<String>): Int {
        return input.map { parser.parse(it) }
            .filter { isPlausibleGame(it) }
            .sumOf { it.gameId }
    }

    @PartTwo
    fun sumGameScores(input: List<String>): Int {
        return input.map { parser.parse(it) }
            .sumOf { calculator.getGameScore(it) }
    }

    private fun isPlausibleGame(game: CubeGame): Boolean {
        return calculator.getMaxRedCount(game) <= MAX_RED_COUNT
                && calculator.getMaxGreenCount(game) <= MAX_GREEN_COUNT
                && calculator.getMaxBlueCount(game) <= MAX_BLUE_COUNT
    }

}
