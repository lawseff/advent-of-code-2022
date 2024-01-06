package io.github.lawseff.aoc2023.challenge

fun String.asInput(): List<String> {
    return this.trimIndent().lines()
}