package io.github.lawseff.aoc2023.matrix

import io.github.lawseff.aoclib.Day
import io.github.lawseff.aoclib.PartOne
import io.github.lawseff.aoclib.PartTwo
import java.util.LinkedList
import java.util.Queue

data class Gear(val partNumbers: List<Int>)

@Day(3) // TODO split into classes and refactor the spaghetti code
class MatrixProblemSolver {

    @PartOne
    fun sumPartNumbers(input: List<String>): Int {
        TODO("Didn't push the commit, before reinstalling the OS. Back up your work!")
    }

    @PartTwo
    fun sumGearRatios(input: List<String>): Int {
        val matrix = input.map { it.toCharArray() }.toTypedArray()

        fun getDigit(x: Int, y: Int): Int? {
            val row = matrix.getOrNull(y) ?: return null
            val cell = row.getOrNull(x) ?: return null
            return if (cell.isDigit()) {
                cell.digitToInt()
            } else {
                null
            }
        }

        fun getFirstNumberChars(startX: Int, y: Int, goForward: Boolean): String? {
            val builder = StringBuilder()
            val step = if (goForward) {
                1
            } else {
                -1
            }

            val xQueue: Queue<Int> = LinkedList()
            xQueue.add(startX)
            while (xQueue.isNotEmpty()) {
                val xToCheck = xQueue.poll()
                val digit = getDigit(xToCheck, y)
                if (digit != null) {
                    if (goForward) {
                        builder.append(digit)
                    } else {
                        builder.insert(0, digit)
                    }
                    xQueue.add(xToCheck + step)
                }
            }

            return if (builder.isNotEmpty()) {
                builder.toString()
            } else {
                null
            }
        }

        // the digit at (startX, y) is included, if present
        fun getAdjacentNumbers(startX: Int, y: Int): List<Int> {
            val numbers = mutableListOf<Int>()

            val middleDigit = getDigit(startX, y)
            if (middleDigit != null) {
                val digits = (getFirstNumberChars(startX - 1, y, false) ?: "") +
                        middleDigit.toString() +
                        (getFirstNumberChars(startX + 1, y, true) ?: "")
                numbers.add(digits.toInt())
            } else {
                val numberToLeft = getFirstNumberChars(startX - 1, y, false)
                if (numberToLeft != null) {
                    numbers.add(numberToLeft.toInt())
                }
                val numberToRight = getFirstNumberChars(startX + 1, y, true)
                if (numberToRight != null) {
                    numbers.add(numberToRight.toInt())
                }
            }

            return numbers
        }

        val gears = mutableListOf<io.github.lawseff.aoc2023.matrix.Gear>()
        matrix.forEachIndexed { y, rowArray ->
            rowArray.forEachIndexed { x, cell ->
                if (cell == '*') {
                    val partNumbers = mutableListOf<Int>()

                    val numbersAbove = getAdjacentNumbers(x, y - 1)
                    partNumbers.addAll(numbersAbove)
                    val numbersSameRow = getAdjacentNumbers(x, y)
                    partNumbers.addAll(numbersSameRow)
                    val numbersBelow = getAdjacentNumbers(x, y + 1)
                    partNumbers.addAll(numbersBelow)

                    if (partNumbers.size == 2) {
                        val gear = io.github.lawseff.aoc2023.matrix.Gear(partNumbers)
                        gears.add(gear)
                    }
                }
            }
        }
        return gears.sumOf { calculateGearRatio(it) }
    }

    private fun calculateGearRatio(gear: io.github.lawseff.aoc2023.matrix.Gear): Int {
        return gear.partNumbers.reduce { product, partNumber -> product * partNumber }
    }

}