package io.github.lawseff.adventofcode.challenge.range.almanac.entity

class SourceDestinationRange(
    val sourceType: AlmanacEntity,
    val destinationType: AlmanacEntity,
    val sourceStartId: Int,
    val destinationStartId: Int,
    val rangeLength: Int
)