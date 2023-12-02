package io.github.lawseff.adventofcode.cube

data class CubeSet(val redCount: Int, val greenCount: Int, val blueCount: Int)

data class CubeGame(val id: Int, val sets: List<CubeSet>)
