package io.github.lawseff.aoc2023.set

data class Scratchcard(
    val cardNumber: Int,
    val winningNumbers: Set<Int>,
    val containedNumbers: Set<Int>
)
