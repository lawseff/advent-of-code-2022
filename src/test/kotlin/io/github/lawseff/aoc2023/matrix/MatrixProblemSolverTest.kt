package io.github.lawseff.aoc2023.matrix

import io.github.lawseff.aoc2023.asInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MatrixProblemSolverTest {

    companion object {
        private val INPUT = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...\$.*....
            .664.598..
        """.asInput()
    }

    private val solver = io.github.lawseff.aoc2023.matrix.MatrixProblemSolver()

    @Test
    fun `should sum part numbers`() {
        val sum = solver.sumPartNumbers(INPUT)

        assertEquals(4361, sum)
    }

    @Test
    fun sumGearRatios() {
        val sum = solver.sumGearRatios(INPUT)

        assertEquals(467835, sum)
    }

}