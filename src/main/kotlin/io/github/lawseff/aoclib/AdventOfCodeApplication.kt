package io.github.lawseff.aoclib

import io.github.lawseff.aoc2023.optimization.WinStrategyProblemSolver
import io.github.lawseff.aoclib.runner.DefaultSolutionRunner
import io.github.lawseff.aoclib.runner.SolutionRunner

fun main() {
    val runner: SolutionRunner = DefaultSolutionRunner()
    runner.run(WinStrategyProblemSolver::class)
}
