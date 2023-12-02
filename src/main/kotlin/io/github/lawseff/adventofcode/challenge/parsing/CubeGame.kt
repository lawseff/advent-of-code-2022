package io.github.lawseff.adventofcode.challenge.parsing

data class CubeSet(val redCount: Int, val greenCount: Int, val blueCount: Int)

data class CubeGame(val gameId: Int, val cubeSets: List<CubeSet>)
