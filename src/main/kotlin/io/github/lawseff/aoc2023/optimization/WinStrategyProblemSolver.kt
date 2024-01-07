package io.github.lawseff.aoc2023.optimization

import io.github.lawseff.aoclib.Day
import io.github.lawseff.aoclib.PartOne
import io.github.lawseff.aoclib.PartTwo

@Day(6)
class WinStrategyProblemSolver {

    private val parser = RaceParser()

    private val counter = WinStrategyCounter()

    @PartOne
    fun getProductOfPossibleWins(input: List<String>): Long {
        val races = parser.parseRaces(input)
        return races.map { counter.countWinStrategies(it) }
            .reduce { product, countPerRace -> product * countPerRace }
    }

    @PartTwo
    fun getPossibleWins(input: List<String>): Long {
        val race = parser.parseRace(input)
        return counter.countWinStrategies(race)
    }
    
}