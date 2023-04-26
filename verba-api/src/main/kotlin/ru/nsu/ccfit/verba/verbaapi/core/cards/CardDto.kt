package ru.nsu.ccfit.verba.verbaapi.core.cards

import ru.nsu.ccfit.verba.verbaapi.core.words.WordDto
import ru.nsu.ccfit.verba.verbaapi.domain.card.CardType
import java.io.Serializable
import java.time.OffsetDateTime


data class CardDto(
    var id: Long = 0,
    var create: OffsetDateTime? = null,
    var repetition: OffsetDateTime? = null,
    var type: CardType? = null,
    var word: WordDto? = null
) : Serializable