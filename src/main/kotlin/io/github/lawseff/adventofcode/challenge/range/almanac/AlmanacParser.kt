package io.github.lawseff.adventofcode.challenge.range.almanac

import io.github.lawseff.adventofcode.challenge.range.almanac.entity.Almanac

class AlmanacParser {

    companion object {
        private const val EMPTY_LINE = "\n"

        private const val SEEDS_LIST_PREFIX = "seeds:"

        private const val SOURCE_DESTINATION_DELIMITER = "-to-"

        private const val SOURCE_DESTINATION_SUFFIX = " map:"
    }

    fun parseAlmanac(textRepresentation: List<String>): Almanac {
        val groups = textRepresentation.partition { it.isBlank() }.first // second is the list of blank strings
        TODO()
    }

}