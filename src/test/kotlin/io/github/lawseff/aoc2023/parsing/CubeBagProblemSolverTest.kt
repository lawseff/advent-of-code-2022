package io.github.lawseff.aoc2023.parsing

import io.github.lawseff.aoc2023.asInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CubeBagProblemSolverTest {

    companion object {
        private val INPUT = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
        """.asInput()
    }

    private val solver = CubeBagProblemSolver()

    @Test
    fun `should sum ids of games that are possible`() {
        val sum = solver.sumGameIdsOfPossibleGames(INPUT)

        assertEquals(8, sum)
    }

    @Test
    fun `should sum game scores`() {
        val sum = solver.sumGameScores(INPUT)

        assertEquals(2286, sum)
    }

}