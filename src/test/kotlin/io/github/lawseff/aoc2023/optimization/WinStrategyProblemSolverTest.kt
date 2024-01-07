package io.github.lawseff.aoc2023.optimization

import io.github.lawseff.aoc2023.asInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinStrategyProblemSolverTest {

    private val solver = WinStrategyProblemSolver()

    @Test
    fun `should multiply together numbers of win strategies per race`() {
        val input = """
            Time:      7  15   30
            Distance:  9  40  200
        """.asInput()

        val product = solver.getProductOfPossibleWins(input)

        assertEquals(288, product)
    }

    @Test
    fun `should merge numbers and count possible wins of single race`() {
        val input = """
            Time:      7  15   30
            Distance:  9  40  200
        """.asInput()

        val wins = solver.getPossibleWins(input)

        assertEquals(71503, wins)
    }

}