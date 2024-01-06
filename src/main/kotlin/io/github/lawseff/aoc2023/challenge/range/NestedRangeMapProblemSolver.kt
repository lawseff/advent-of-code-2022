package io.github.lawseff.aoc2023.challenge.range

import io.github.lawseff.aoc2023.Day
import io.github.lawseff.aoc2023.PartOne
import io.github.lawseff.aoc2023.PartTwo
import io.github.lawseff.aoc2023.challenge.range.entity.Almanac
import io.github.lawseff.aoc2023.challenge.range.entity.AlmanacEntityMapping

@Day(5)
class NestedRangeMapProblemSolver {

    private val parser = AlmanacParser()

    @PartOne
    fun findMinLocationIdFromSeedIds(input: List<String>): Long {
        val almanac = parser.parseAlmanac(input)
        val locationsForSeeds = almanac.initialSeeds.map { findLocationId(it, almanac) }
        return locationsForSeeds.min()
    }

    @PartTwo
    fun findMinLocationIdFromSeedIdRanges(input: List<String>): Long {
        TODO()
    }

    private fun findLocationId(seedId: Long, almanac: Almanac): Long {
        return almanac.entityMappings.fold(seedId) { currentId, mapping ->
            findCorrespondingId(currentId, mapping)
        }
    }

    private fun findCorrespondingId(sourceId: Long, mapping: AlmanacEntityMapping): Long {
        var correspondingId = sourceId
        for (range in mapping.ranges) {
            val sourceStartId = range.sourceStartId
            val sourceEndId = sourceStartId + range.rangeLength - 1
            if (correspondingId in sourceStartId..sourceEndId) {
                val destinationSourceDifference = range.destinationStartId - range.sourceStartId
                correspondingId += destinationSourceDifference
                break
            }
        }
        return correspondingId
    }

}