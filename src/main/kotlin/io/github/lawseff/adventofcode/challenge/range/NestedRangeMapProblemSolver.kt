package io.github.lawseff.adventofcode.challenge.range

import io.github.lawseff.adventofcode.Day
import io.github.lawseff.adventofcode.PartOne
import io.github.lawseff.adventofcode.challenge.range.almanac.AlmanacParser

@Day(5)
class NestedRangeMapProblemSolver {

    private val parser = AlmanacParser()

    @PartOne
    fun findLowestLocationIdFromSeedIds(input: List<String>): Int {
        val almanac = parser.parseAlmanac(input)
        return 0
    }

}