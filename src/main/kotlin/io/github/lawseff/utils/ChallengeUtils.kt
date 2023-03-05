package io.github.lawseff.utils

import io.github.lawseff.day1.CalorieCountingProblemSolver
import io.github.lawseff.day2.RockPaperScissorsProblemSolver
import io.github.lawseff.day3.RucksackReorganizationProblemSolver
import io.github.lawseff.day4.CampCleanupProblemSolver
import io.github.lawseff.day5.SupplyStackProblemSolver
import java.io.File
import java.time.LocalDate
import java.time.temporal.ChronoUnit

private val START_DATE = LocalDate.of(2022, 12, 1)
private const val INPUT_PATH = "src/main/resources/day%d/input.txt"
private const val OUTPUT_PATH = "src/main/resources/day%d/output.txt"
private val SOLVER_MAPPING = mapOf(
    1 to CalorieCountingProblemSolver(),
    2 to RockPaperScissorsProblemSolver(),
    3 to RucksackReorganizationProblemSolver(),
    4 to CampCleanupProblemSolver(),
    5 to SupplyStackProblemSolver(),
)

class ChallengeUtils {
    companion object {
        fun getTodaysDayNumber() =
            ChronoUnit.DAYS.between(START_DATE, LocalDate.now()).toInt() + 1

        fun getProblemSolver(day: Int) = SOLVER_MAPPING[day]
            ?: throw UnsupportedOperationException("Day $day problem solver is not supported")

        fun readInput(day: Int): List<String> = getInputFile(day).readLines()

        fun writeOutput(day: Int, output: Any?) = getOutputFile(day).writeText(output.toString())

        private fun getInputFile(day: Int): File {
            val file = File(INPUT_PATH.format(day))
            return file.takeIf { it.exists() } ?: error("No file found: $file")
        }

        private fun getOutputFile(day: Int): File = File(OUTPUT_PATH.format(day))
    }
}
