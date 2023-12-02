package io.github.lawseff.adventofcode

import io.github.lawseff.adventofcode.runner.DefaultSolutionRunner
import io.github.lawseff.adventofcode.runner.SolutionRunner
import io.github.lawseff.adventofcode.solver.FirstLastDigitProblemSolver

fun main() {
    val runner: SolutionRunner = DefaultSolutionRunner()
    runner.run(FirstLastDigitProblemSolver::class)
}
