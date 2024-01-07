package io.github.lawseff.aoc2023.parsing

class CubeGameParser {

    companion object {
        private const val PREFIX = "Game "
        private const val GAME_DELIMITER = ": "
        private const val SET_DELIMITER = "; "
        private const val CUBE_DELIMITER = ", "
        private const val RED_CUBES = " red"
        private const val GREEN_CUBES = " green"
        private const val BLUE_CUBES = " blue"
    }

    fun parse(input: String): CubeGame {
        val withoutPrefix = input.removePrefix(PREFIX)
        val gameIdAndSets = withoutPrefix.split(GAME_DELIMITER)
        val gameId = gameIdAndSets[0].toInt()
        val sets = gameIdAndSets[1].split(SET_DELIMITER)
            .map { parseSet(it) }
        return CubeGame(gameId, sets)
    }

    private fun parseSet(input: String): CubeSet {
        val splitColors = input.split(CUBE_DELIMITER)
        val red = parseColorCount(splitColors, RED_CUBES)
        val green = parseColorCount(splitColors, GREEN_CUBES)
        val blue = parseColorCount(splitColors, BLUE_CUBES)
        return CubeSet(red, green, blue)
    }

    private fun parseColorCount(splitColors: List<String>, colorSuffix: String): Int {
        return splitColors.firstOrNull { it.contains(colorSuffix) }
            ?.removeSuffix(colorSuffix)
            ?.toInt() ?: 0
    }

}
