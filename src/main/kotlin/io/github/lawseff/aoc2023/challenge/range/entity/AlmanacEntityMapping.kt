package io.github.lawseff.aoc2023.challenge.range.entity

class AlmanacEntityMapping(
    val sourceType: AlmanacEntity,
    val destinationType: AlmanacEntity,
    val ranges: List<SourceDestinationRange>
)