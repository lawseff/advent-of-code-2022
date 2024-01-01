package io.github.lawseff.adventofcode.challenge.range.entity

class AlmanacEntityMapping(
    val sourceType: AlmanacEntity,
    val destinationType: AlmanacEntity,
    val ranges: List<SourceDestinationRange>
)