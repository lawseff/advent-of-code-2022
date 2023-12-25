package io.github.lawseff.adventofcode.challenge.set

data class Scratchcard(
    val cardNumber: Int,
    val winningNumbers: Set<Int>,
    val containedNumbers: Set<Int>
)
