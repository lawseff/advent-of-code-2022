package io.github.lawseff.aoc2023.challenge.set

import io.github.lawseff.aoc2023.Day
import io.github.lawseff.aoc2023.PartOne
import io.github.lawseff.aoc2023.PartTwo
import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

@Day(4)
class SetIntersectionProblemSolver {

    companion object {
        private const val ZERO = 0L
        private const val ONE = 1L
    }

    private val parser = ScratchcardParser()

    @PartOne
    fun sumPoints(input: List<String>): Long {
        val cards = input.map { parser.parseCard(it) }
        return cards.sumOf { card ->
            val intersectedNumberCount = getIntersectedNumberCount(card)
            if (intersectedNumberCount > 0) {
                val exponent = intersectedNumberCount - 1
                powerOfTwo(exponent)
            } else {
                ZERO
            }
        }
    }

    @PartTwo
    fun countCardsAndCopies(input: List<String>): Int {
        val cards = input.associate {
            val card = parser.parseCard(it)
            card.cardNumber to card
        }
        val maxCardNumber = cards.size
        val cardQueue: Queue<Scratchcard> = LinkedList()
        cards.forEach {
            cardQueue.add(it.value)
        }
        var cardCount = 0
        while (cardQueue.isNotEmpty()) {
            val card = cardQueue.poll()
            cardCount++

            val firstDuplicateCardNumber = card.cardNumber + 1
            val intersectedNumberCount = getIntersectedNumberCount(card)
            val lastDuplicateCardNumber = min(card.cardNumber + intersectedNumberCount, maxCardNumber)
            for (i in firstDuplicateCardNumber.. lastDuplicateCardNumber) {
                val duplicateCard = cards[i]
                cardQueue.add(duplicateCard)
            }
        }
        return cardCount
    }

    private fun getIntersectedNumberCount(card: Scratchcard): Int {
        val winningNumbers = card.winningNumbers
        val containedNumbers = card.containedNumbers
        val intersectedNumbers = winningNumbers.intersect(containedNumbers)
        return intersectedNumbers.size
    }

    private fun powerOfTwo(exponent: Int): Long {
        return ONE shl exponent
    }

}