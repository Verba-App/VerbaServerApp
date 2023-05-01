package ru.nsu.ccfit.verba.verbaapi.core.cards

import java.time.OffsetDateTime

data class StatusCardDto(
    val stages: Long,
    val repetitionDate: OffsetDateTime
)
