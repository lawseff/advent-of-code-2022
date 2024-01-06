package io.github.lawseff.aoc2023

import io.github.lawseff.aoc2023.challenge.range.NestedRangeMapProblemSolver
import io.github.lawseff.aoc2023.runner.DefaultSolutionRunner
import io.github.lawseff.aoc2023.runner.SolutionRunner

fun main() {
    val runner: SolutionRunner = DefaultSolutionRunner()
    runner.run(NestedRangeMapProblemSolver::class)
}
