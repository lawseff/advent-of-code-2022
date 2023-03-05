package io.github.lawseff.day4

import io.github.lawseff.challenge.ProblemSolver

class CampCleanupProblemSolver: ProblemSolver {
    override fun getAnswer(input: List<String>): Any {
        return listOf(
            findRangeIncludeCount(input),
            findRangeOverlapCount(input),
        )
    }

    private fun findRangeIncludeCount(input: List<String>): Int {
        return input.count { isIncluding(it) }
    }

    private fun findRangeOverlapCount(input: List<String>): Int {
        return input.count { isOverlapping(it) }
    }

    private fun isIncluding(assignments: String): Boolean {
        val (firstStart, firstEnd, secondStart, secondEnd) = getAssignmentRanges(assignments)
        val startDiff = firstStart - secondStart
        val endDiff = firstEnd - secondEnd
        return startDiff * endDiff <= 0
    }

    private fun isOverlapping(assignments: String): Boolean {
        val (a, b, c, d) = getAssignmentRanges(assignments)
        return a <= d && b >= c
    }

    private fun getAssignmentRanges(assignments: String): Array<Int> {
        val (firstElfAssignment, secondElfAssignment) = assignments.split(',')
        val (firstStart, firstEnd) = firstElfAssignment.split('-').map { it.toInt() }
        val (secondStart, secondEnd) = secondElfAssignment.split('-').map { it.toInt() }
        return arrayOf(firstStart, firstEnd, secondStart, secondEnd)
    }
}