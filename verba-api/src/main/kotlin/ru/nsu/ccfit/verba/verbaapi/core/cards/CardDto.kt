package ru.nsu.ccfit.verba.verbaapi.core.cards

import ru.nsu.ccfit.verba.verbaapi.core.words.WordDto
import ru.nsu.ccfit.verba.verbaapi.domain.card.CardType
import java.io.Serializable
import java.time.OffsetDateTime

open class CardDto(
    open var id: Long = 0,
    open var createDate: OffsetDateTime?,
    open var type: CardType?,
    open var word: WordDto?
) : Serializable