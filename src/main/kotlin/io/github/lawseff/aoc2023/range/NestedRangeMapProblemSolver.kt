package io.github.lawseff.aoc2023.range

import io.github.lawseff.aoc2023.range.entity.AlmanacEntityMapping
import io.github.lawseff.aoc2023.range.entity.Range
import io.github.lawseff.aoc2023.range.entity.SourceDestinationRange
import io.github.lawseff.aoclib.Day
import io.github.lawseff.aoclib.PartOne
import io.github.lawseff.aoclib.PartTwo

@Day(5)
class NestedRangeMapProblemSolver {

    private val parser = AlmanacParser()

    @PartOne
    fun findMinLocationIdFromSeedIds(input: List<String>): Long {
        val almanac = parser.parseAlmanac(input)
        val locations = almanac.initialSeeds.map { findLastCorrespondingId(it, almanac.entityMappings) }
        return locations.min()
    }

    // This is a brute-force solution
    @PartTwo
    fun findMinLocationIdFromSeedIdRanges(input: List<String>): Long {
        val almanac = parser.parseAlmanac(input)
        val entityMappings = invert(almanac.entityMappings)
        val seedRanges = almanac.initialSeeds.chunked(2)
            .map { Range(it[0], it[1]) }

        var locationId = 1L
        while (!contains(seedRanges, findLastCorrespondingId(locationId, entityMappings))) {
            locationId++
        }
        return locationId
    }

    private fun findLastCorrespondingId(startId: Long, entityMappings: List<AlmanacEntityMapping>): Long {
        return entityMappings.fold(startId) { currentId, mapping ->
            findNextCorrespondingId(currentId, mapping)
        }
    }

    private fun findNextCorrespondingId(sourceId: Long, mapping: AlmanacEntityMapping): Long {
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

    private fun invert(mappings: List<AlmanacEntityMapping>): List<AlmanacEntityMapping> {
        return mappings.reversed().map { invert(it) }
    }

    private fun invert(mapping: AlmanacEntityMapping): AlmanacEntityMapping {
        val sourceType = mapping.destinationType
        val destinationType = mapping.sourceType
        val ranges = mapping.ranges.map {
            SourceDestinationRange(it.destinationStartId, it.sourceStartId, it.rangeLength)
        }
        return AlmanacEntityMapping(sourceType, destinationType, ranges)
    }

    private fun contains(ranges: List<Range>, id: Long): Boolean {
        return ranges.any { contains(it, id) }
    }

    private fun contains(range: Range, id: Long): Boolean {
        val startId = range.startId
        val endId = startId + range.rangeLength - 1
        return id in startId..endId
    }

}