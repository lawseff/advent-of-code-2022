package io.github.lawseff.day5

import io.github.lawseff.challenge.ProblemSolver
import java.util.LinkedList

class SupplyStackProblemSolver: ProblemSolver {
    override fun getAnswer(input: List<String>): Any {
        return listOf(
            getStackTops(input)
        )
    }

    private fun getStackTops(input: List<String>): String {
        val blankLineIndex = input.indexOfFirst { it.isBlank() }
        val stackState = input.subList(0, blankLineIndex - 1)
        val operations = input.subList(blankLineIndex + 1, input.size)
//        val stacks = stackState.map { it.substring(1, it.lastIndex).chunked(4).map { it.trim().removePrefix("[").removeSuffix("]").toList() } }
        val numberLine = input[blankLineIndex - 1]
        val stackCount = numberLine.substring(numberLine.lastIndexOf(' ') + 1).toInt()
        val stacks = 1.rangeTo(stackCount).map { LinkedList<Char>() }
        stackState.forEach {

        }
        println(stacks)
        return ""
    }
}