package io.github.lawseff.aoc2023.optimization

class RaceParser {

    companion object {
        private const val TIME_PREFIX = "Time:"

        private const val TIME_LINE_INDEX = 0

        private const val DISTANCE_PREFIX = "Distance:"

        private const val DISTANCE_LINE_INDEX = 1

        private val WHITESPACES = "\\s+".toRegex()
    }

    fun parseRaces(textRepresentation: List<String>): List<Race> {
        val times = convertToNumbers(textRepresentation[TIME_LINE_INDEX], TIME_PREFIX)
        val distances = convertToNumbers(textRepresentation[DISTANCE_LINE_INDEX], DISTANCE_PREFIX)
        return times.zip(distances).map {
            val time = it.first
            val distance = it.second
            Race(time, distance)
        }
    }
    
    fun parseRace(textRepresentation: List<String>): Race {
        val time = mergeAndConvertToNumber(textRepresentation[TIME_LINE_INDEX], TIME_PREFIX)
        val distance = mergeAndConvertToNumber(textRepresentation[DISTANCE_LINE_INDEX], DISTANCE_PREFIX)
        return Race(time, distance)
    }

    private fun convertToNumbers(line: String, prefix: String): List<Long> {
        return line.removePrefix(prefix)
            .trim()
            .split(WHITESPACES)
            .map { it.toLong() }
    }

    private fun mergeAndConvertToNumber(line: String, prefix: String): Long {
        return line.removePrefix(prefix)
            .trim()
            .replace(WHITESPACES, "")
            .toLong()
    }
    
}