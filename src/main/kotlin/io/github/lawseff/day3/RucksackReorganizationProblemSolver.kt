package io.github.lawseff.day3

import io.github.lawseff.challenge.ProblemSolver
import java.lang.IllegalArgumentException

class RucksackReorganizationProblemSolver: ProblemSolver {
    override fun getAnswer(input: List<String>): Any {
        return listOf(
            findSameItemPrioritySum(input),
            findGroupBadgePrioritySum(input),
        )
    }

    /**
     * Part 1:
     * The list of items for each rucksack is given as characters all on a single line.
     * The first half of the characters represent items in the first compartment,
     * while the second half of the characters represent items in the second compartment.
     *
     * Lowercase item types a through z have priorities 1 through 26.
     * Uppercase item types A through Z have priorities 27 through 52.
     *
     * Find the item type that appears in both compartments of each rucksack.
     * What is the sum of the priorities of those item types?
     */
    private fun findSameItemPrioritySum(input: List<String>): Int {
        return input.sumOf { findSameItemPriority(it) }
    }

    /**
     * The first half of this puzzle is complete!
     * Part 2:
     * Every set of three lines in your list corresponds to a single group.
     * The badge is one item type that is common between all three Elves in each group.
     * What is the sum of the priorities of those item types?
     */
    private fun findGroupBadgePrioritySum(input: List<String>): Int {
        return input.chunked(3)
            .map { findCommonChar(it) }
            .sumOf { itemToPriority(it) }
    }

    private fun findSameItemPriority(items: String): Int {
        val mid = items.length / 2
        val leftCompartment = items.substring(0, mid)
        val rightCompartment = items.substring(mid)
        val sameChar = leftCompartment.find { rightCompartment.contains(it) }
            ?: throw IllegalArgumentException("No same item found: $items")
        return itemToPriority(sameChar)
    }

    private fun findCommonChar(groupItems: List<String>): Char {
        return groupItems.map { it.toSet() }
            .reduce { resultSet, it -> resultSet.intersect(it) }
            .first()
    }

    private fun itemToPriority(item: Char): Int =
        if(item.isUpperCase()) (item - 38).code else (item - 96).code

}