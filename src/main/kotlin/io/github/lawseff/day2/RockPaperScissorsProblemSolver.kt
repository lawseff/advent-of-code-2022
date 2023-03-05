package io.github.lawseff.day2

import io.github.lawseff.challenge.ProblemSolver

class RockPaperScissorsProblemSolver: ProblemSolver {
    override fun getAnswer(input: List<String>): Any? {
        return listOf(
            calculateTotalScore(input),
            calculateTotalScorePart2(input),
        )
    }

    /**
     * Part 1:
     * A for Rock, B for Paper, and C for Scissors - opponent.
     * X for Rock, Y for Paper, and Z for Scissors - response.
     * Score:
     * 1 for Rock, 2 for Paper, and 3 for Scissors + 0 (loss), 3 (draw) or 6 (win).
     */
    private fun calculateTotalScore(input: List<String>): Int {
        var totalScore = 0
        input.forEach { line ->
            val secondPlayerMove = line.codePointAt(0) - 'A'.code + 1
            val firstPlayerMove = line.codePointAt(2) - 'X'.code + 1
            val outcome = (3 + firstPlayerMove - secondPlayerMove) % 3
            val roundScore = firstPlayerMove + if (outcome == 0) 3 else if (outcome == 1) 6 else 0
            totalScore += roundScore
        }
        return totalScore
    }

    /**
     * Anyway, the second column says how the round needs to end:
     * X means you need to lose,
     * Y means you need to end the round in a draw,
     * and Z means you need to win.
     */
    private fun calculateTotalScorePart2(input: List<String>): Int {
        var totalScore = 0
        input.forEach { line ->
            val secondPlayerMove = line.codePointAt(0) - 'A'.code + 1
            val expectedOutcome = line.codePointAt(2) - 'X'.code + 1

            // (A + x) % B = C
            // (B + C - A) % B = x
            // (3 - second + first) % 3 = expectedOutcome
            // 3 + expectedOutcome - 3 + second = x
//            totalScore += 3 + expectedOutcome - 3 + secondPlayerMove

            if (expectedOutcome == 1) { // I lose
                if (secondPlayerMove == 1) { // rock
                    totalScore += 3
                } else if (secondPlayerMove == 2) { // paper
                    totalScore += 1
                } else { // scissors
                    totalScore += 2
                }
            }
            if (expectedOutcome == 2) { // Draw
                totalScore += 3
                totalScore += secondPlayerMove
            }
            if (expectedOutcome == 3) { // I win
                totalScore += 6
                if (secondPlayerMove == 1) { // rock
                    totalScore += 2
                } else if (secondPlayerMove == 2) { // paper
                    totalScore += 3
                } else { // scissors
                    totalScore += 1
                }
            }
        }
        return totalScore
    }

    private fun calculateTotalScorev2(input: List<String>): Int {
        var totalScore = 0
        input.forEach { line ->
            val secondPlayerMove = line.codePointAt(0) - 'A'.code + 1
            val firstPlayerMove = line.codePointAt(2) - 'X'.code + 1
            totalScore += firstPlayerMove
            if (firstPlayerMove == secondPlayerMove) {
                totalScore += 3
            }
            // 1 - rock, 2 - paper, 3 - scissors
            if (firstPlayerMove == 1) {
                if (secondPlayerMove == 3) {
                    totalScore += 6
                }
            } else if (firstPlayerMove == 2) {
                if (secondPlayerMove == 1) {
                    totalScore += 6
                }
            } else {
                if (secondPlayerMove == 2) {
                    totalScore += 6
                }
            }
        }
        return totalScore
    }
}
