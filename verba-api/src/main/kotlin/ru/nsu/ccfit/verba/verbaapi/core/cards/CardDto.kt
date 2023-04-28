package ru.nsu.ccfit.verba.verbaapi.core.cards

import ru.nsu.ccfit.verba.verbaapi.core.words.WordDto
import ru.nsu.ccfit.verba.verbaapi.domain.card.CardType
import java.io.Serializable
import java.time.OffsetDateTime

/**
 * A DTO for the {@link ru.nsu.ccfit.verba.verbaapi.domain.card.Card} entity
 */
open class CardDto(
    open var id: Long = 0,
    open var createe: OffsetDateTime? = null,
    open var repetition: OffsetDateTime? = null,
    open var type: CardType? = null,
    open var word: WordDto? = null
) : Serializable