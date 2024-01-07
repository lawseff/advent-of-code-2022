package io.github.lawseff.aoc2023.range

import io.github.lawseff.aoc2023.asInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NestedRangeMapProblemSolverTest {

    companion object {
        private val INPUT = """
            seeds: 79 14 55 13

            seed-to-soil map:
            50 98 2
            52 50 48

            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15

            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4

            water-to-light map:
            88 18 7
            18 25 70

            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13

            temperature-to-humidity map:
            0 69 1
            1 0 69

            humidity-to-location map:
            60 56 37
            56 93 4
        """.asInput()
    }

    private val solver = NestedRangeMapProblemSolver()

    @Test
    fun `should find min location id corresponding to any seed id`() {
        val minLocationId = solver.findMinLocationIdFromSeedIds(INPUT)

        assertEquals(35, minLocationId)
    }

    @Test
    fun `should find min location id corresponding to any seed id in range`() {
        val minLocationId = solver.findMinLocationIdFromSeedIdRanges(INPUT)

        assertEquals(46, minLocationId)
    }

}