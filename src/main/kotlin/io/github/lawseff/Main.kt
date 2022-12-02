package io.github.lawseff

import io.github.lawseff.utils.ChallengeUtils

fun main() {
    val day = ChallengeUtils.getTodaysDayNumber()
    val problemSolver = ChallengeUtils.getProblemSolver(day)

    val input = ChallengeUtils.readInput(day)
    val answer = problemSolver.getAnswer(input)

    ChallengeUtils.writeOutput(day, answer)
}
