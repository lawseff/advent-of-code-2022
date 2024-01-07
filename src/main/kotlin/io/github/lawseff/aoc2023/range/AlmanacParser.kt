package io.github.lawseff.aoc2023.range

import io.github.lawseff.aoc2023.range.entity.Almanac
import io.github.lawseff.aoc2023.range.entity.AlmanacEntity
import io.github.lawseff.aoc2023.range.entity.AlmanacEntityMapping
import io.github.lawseff.aoc2023.range.entity.SourceDestinationRange

class AlmanacParser {

    companion object {

        private const val SEEDS_LIST_PREFIX = "seeds: "

        private const val SPACE = " "

        private const val SOURCE_DESTINATION_DELIMITER = "-to-"

        private const val SOURCE_DESTINATION_SUFFIX = " map:"

    }

    fun parseAlmanac(textRepresentation: List<String>): Almanac {
        val textGroups = split(textRepresentation, String::isBlank)
        val seeds = parseSeedList(textGroups[0])
        val entityMappings = textGroups.subList(1, textGroups.size)
            .map { parseEntityMapping(it) }
        return Almanac(seeds, entityMappings)
    }

    private fun split(text: List<String>, isDelimiter: (line: String) -> Boolean): List<List<String>> {
        return text.fold(mutableListOf<MutableList<String>>()) { listOfGroups, line ->
            if (isDelimiter(line)) {
                val newGroup = mutableListOf<String>()
                listOfGroups.add(newGroup)
            } else {
                if (listOfGroups.isEmpty()) {
                    val newGroup = mutableListOf<String>()
                    listOfGroups.add(newGroup)
                }
                val group = listOfGroups.last()
                group.add(line)
            }
            listOfGroups
        }
    }

    /**
     * Example:
     *
     * ```
     * """seeds: 12 100 99 34
     * 93 42"""
     * -> [12, 100, 99, 34, 93, 42]
     * ```
     */
    private fun parseSeedList(textRepresentation: List<String>): List<Long> {
        return textRepresentation.joinToString(SPACE)
            .removePrefix(SEEDS_LIST_PREFIX)
            .split(SPACE)
            .map { it.toLong() }
    }

    /**
     * Example:
     *
     * ```
     * """temperature-to-humidity map:
     * 0 69 1
     * 1 0 69"""
     * -> [SourceDestinationRange(TEMPERATURE, HUMIDITY, 69, 0, 1), SourceDestinationRange(0, 1, 69)]
     * ```
     */
    private fun parseEntityMapping(textRepresentation: List<String>): AlmanacEntityMapping {
        val header = textRepresentation[0]
        val (sourceType, destinationType) = header.removeSuffix(SOURCE_DESTINATION_SUFFIX)
            .split(SOURCE_DESTINATION_DELIMITER)
            .let {
                val source = AlmanacEntity.fromCode(it[0])
                val destination = AlmanacEntity.fromCode(it[1])
                source to destination
            }
        val ranges = textRepresentation.subList(1, textRepresentation.size)
            .map { rangeRepresentation ->
                // destination is the 1st value, source is the 2nd, range is the 3rd
                val (destinationStartId, sourceStartId, rangeLength) = rangeRepresentation.split(SPACE)
                    .map { it.toLong() }
                SourceDestinationRange(sourceStartId, destinationStartId, rangeLength)
            }
        return AlmanacEntityMapping(sourceType, destinationType, ranges)
    }

}