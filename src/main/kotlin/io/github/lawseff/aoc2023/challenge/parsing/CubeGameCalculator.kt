package io.github.lawseff.aoc2023.challenge.parsing

class CubeGameCalculator {

    fun getGameScore(game: CubeGame): Int {
        return getMaxRedCount(game) * getMaxGreenCount(game) * getMaxBlueCount(game)
    }

    fun getMaxRedCount(game: CubeGame): Int {
        return game.cubeSets.maxOf { it.redCount }
    }

    fun getMaxGreenCount(game: CubeGame): Int {
        return game.cubeSets.maxOf { it.greenCount }
    }

    fun getMaxBlueCount(game: CubeGame): Int {
        return game.cubeSets.maxOf { it.blueCount }
    }

}
