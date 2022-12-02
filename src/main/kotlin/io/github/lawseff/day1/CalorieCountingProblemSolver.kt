package io.github.lawseff.day1

import io.github.lawseff.challenge.ProblemSolver
import java.lang.IllegalArgumentException

class CalorieCountingProblemSolver: ProblemSolver {
    override fun getAnswer(input: List<String>): Any {
        return listOf(
            findTopCalorieSum(input),
            findTopThreeCalorieSum(input),
        )
    }

    /**
     * Part 1:
     *  Find the Elf carrying the most Calories.
     *  How many total Calories is that Elf carrying?
     */
    private fun findTopCalorieSum(input: List<String>): Int {
        if (input.isEmpty()) {
            throw IllegalArgumentException("No elves found")
        }

        var max = 0
        var current = 0
        input.forEachIndexed { index, line ->
            if (line.isNotBlank()) {
                current += line.toInt()
            } else {
                if (current > max) {
                    max = current
                }
                current = 0
            }
            if (index == input.lastIndex && current > max) {
                max = current
            }
        }

        return max
    }

    /**
     * The first half of this puzzle is complete!
     * Part 2:
     *  Find the top three Elves carrying the most Calories.
     *  How many Calories are those Elves carrying in total?
     */
    private fun findTopThreeCalorieSum(input: List<String>): Int {
        val elvesCalories = mutableListOf<Int>()
        var current = 0
        input.forEachIndexed { index, line ->
            if (line.isNotBlank()) {
                current += line.toInt()
            } else {
                elvesCalories.add(current)
                current = 0
            }
            if (index == input.lastIndex) {
                elvesCalories.add(current)
            }
        }
        elvesCalories.sortDescending()
        return elvesCalories.subList(0, 3).sum()
    }
}
