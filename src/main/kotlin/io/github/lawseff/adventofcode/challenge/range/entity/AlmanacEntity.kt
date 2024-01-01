package io.github.lawseff.adventofcode.challenge.range.entity

enum class AlmanacEntity(val code: String) {
    SEED("seed"),
    SOIL("soil"),
    FERTILIZER("fertilizer"),
    WATER("water"),
    LIGHT("light"),
    TEMPERATURE("temperature"),
    HUMIDITY("humidity"),
    LOCATION("location");

    companion object {
        fun fromCode(code: String): AlmanacEntity {
            return entries.find { it.code == code }
                ?: throw IllegalArgumentException("Invalid code: $code")
        }
    }

}