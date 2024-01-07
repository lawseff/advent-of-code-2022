package io.github.lawseff.aoc2023

fun String.asInput(): List<String> {
    return this.trimIndent().lines()
}