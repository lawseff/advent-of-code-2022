package io.github.lawseff.adventofcode.solver

import io.github.lawseff.adventofcode.Day
import io.github.lawseff.adventofcode.PartOne

data class CubeSet(val redCount: Int, val greenCount: Int, val blueCount: Int)

data class Game(val id: Int, val cubeSets: List<CubeSet>)

@Day(2)
class BagCubeProblemSolver {

    @PartOne
    fun sumGameIdsOfPossibleGames(input: List<String>): Int {
        val games = input.map { mapToGame(it) }
        return games.filter { game ->
            return@filter game.cubeSets.sumOf { it.redCount } <= 12
                    && game.cubeSets.sumOf { it.greenCount } <= 13
                    && game.cubeSets.sumOf { it.blueCount } <= 14
//            val totalGreen = game.cubeSets.sumOf { it.greenCount }
//            val totalBlue = game.cubeSets.sumOf { it.blueCount }
        }.sumOf { game -> game.id }
    }

    private fun mapToGame(input: String): Game {
        val withoutPrefix = input.removePrefix("Game ")
        val gameIdAndSets = withoutPrefix.split(":")
        val gameId = gameIdAndSets[0].toInt()
        val sets = gameIdAndSets[1].split(";").map { set ->
            val countByColor = set.split(",").map { it.trim() }
            val red = countByColor.firstOrNull { it.contains("red") }?.split(" ")?.get(0)?.toInt() ?: 0
            val green = countByColor.firstOrNull { it.contains("green") }?.split(" ")?.get(0)?.toInt() ?: 0
            val blue = countByColor.firstOrNull { it.contains("blue") }?.split(" ")?.get(0)?.toInt() ?: 0
            return@map CubeSet(red, green, blue)
        }
        return Game(gameId, sets)
    }

}
