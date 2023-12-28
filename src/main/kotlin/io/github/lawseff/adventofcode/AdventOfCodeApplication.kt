package io.github.lawseff.adventofcode

import io.github.lawseff.adventofcode.challenge.range.NestedRangeMapProblemSolver
import io.github.lawseff.adventofcode.runner.DefaultSolutionRunner
import io.github.lawseff.adventofcode.runner.SolutionRunner

fun main() {
    val runner: SolutionRunner = DefaultSolutionRunner()
    runner.run(NestedRangeMapProblemSolver::class)
}
