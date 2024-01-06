package io.github.lawseff.aoc2023.challenge.set

class ScratchcardParser {

    companion object {
        private const val CARD_PREFIX = "Card"

        private const val COLON = ':'

        private const val VERTICAL_BAR = '|'

        private const val SPACE = ' '
    }

    // Format example:
    // Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
    fun parseCard(stringRepresentation: String): Scratchcard {
        // TODO: regex validation?
        val withoutPrefix = stringRepresentation.removePrefix(CARD_PREFIX).trimStart()
        val colonIndex = withoutPrefix.indexOf(COLON)
        val cardNumber = withoutPrefix.substring(0, colonIndex).toInt()
        val numberGroups = withoutPrefix.removeRange(0, colonIndex + 1)
            .trim()
            .split(VERTICAL_BAR)
        val winningNumbers = convertToNumberSet(numberGroups[0])
        val containedNumbers = convertToNumberSet(numberGroups[1])
        return Scratchcard(cardNumber, winningNumbers, containedNumbers)
    }

    private fun convertToNumberSet(numberGroup: String): Set<Int> {
        return numberGroup.split(SPACE)
            .filter { it.isNotBlank() }
            .map { it.toInt() }
            .toSet()
    }

}