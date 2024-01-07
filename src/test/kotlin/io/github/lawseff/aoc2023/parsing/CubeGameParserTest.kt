package io.github.lawseff.aoc2023.parsing

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CubeGameParserTest {

    private val parser = CubeGameParser()

    @Test
    fun `parses instance from string`() {
        val input = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
        val expectedGame = CubeGame(
            3, listOf(
                CubeSet(20, 8, 6),
                CubeSet(4, 13, 5),
                CubeSet(1, 5, 0),
            )
        )

        val actualGame = parser.parse(input)

        assertEquals(expectedGame, actualGame)
    }

}
