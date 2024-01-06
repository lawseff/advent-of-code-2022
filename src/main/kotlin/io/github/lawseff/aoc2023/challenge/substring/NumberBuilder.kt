package io.github.lawseff.aoc2023.challenge.substring

/**
 * Class for building numbers from digits, that are contained in a string input
 */
class NumberBuilder {

    companion object {
        private val DIGITS_BY_WORDS = mapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,
        )

        // Matches any digit from [0-9] and digits spelled out with letters.
        private const val DIGIT = "\\d|zero|one|two|three|four|five|six|seven|eight|nine"

        // Matches a substring starting with a digit and ending with a digit.
        // Captures only the first digit (group 1) and the last digit (group 2, if present).
        private val MATCHER = "($DIGIT)(?:.*($DIGIT))?".toRegex()
    }

    /**
     * Returns a number, consisting of the first digit and the last digit of a [String] value. If
     * the value contains only one digit, it is considered both as the first and the last.
     *
     * @param input string value to build a number from
     * @return two-digit number from the first and the last digit occurrence
     */
    fun buildFromFirstLastDigit(input: String): Int {
        val firstDigit = input.first { it.isDigit() }
        val lastDigit = input.last { it.isDigit() }
        return "$firstDigit$lastDigit".toInt()
    }

    /**
     * *Alpha-digit* is a digit, written either numerically (0-9) or with lowercase letters
     * ("zero", "one", etc.).
     *
     * Returns a number, consisting of the first *alpha-digit* and the *last alpha-digit* of a
     * [String] value. The result contains only numerical digits. If the value contains only one
     * *alpha-digit*, it is considered both as the first and the last.
     *
     * @param input string value to build a number from
     * @return two-digit number from the first and the last alpha-digit occurrence
     */
    fun buildFromFirstLastAlphaDigit(input: String): Int {
        val matchResult = MATCHER.find(input) ?: throw NoSuchElementException()

        // captured groups start with 1; 0 is the entire match
        val firstDigit = parseAlphaDigit(matchResult.groupValues[1])
        val lastDigit = if (matchResult.groupValues[2].isNotEmpty()) {
            parseAlphaDigit(matchResult.groupValues[2])
        } else {
            firstDigit
        }
        return "$firstDigit$lastDigit".toInt()
    }

    private fun parseAlphaDigit(alphaDigit: String): Int {
        return if (alphaDigit.length == 1) {
            alphaDigit.toInt()
        } else {
            DIGITS_BY_WORDS[alphaDigit] ?: throw IllegalArgumentException()
        }
    }

}
