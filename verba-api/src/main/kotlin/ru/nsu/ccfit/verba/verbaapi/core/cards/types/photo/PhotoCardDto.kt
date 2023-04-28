package ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo

import ru.nsu.ccfit.verba.verbaapi.core.cards.CardDto
import ru.nsu.ccfit.verba.verbaapi.core.resource.PhotoResourceDto
import ru.nsu.ccfit.verba.verbaapi.core.words.WordDto
import ru.nsu.ccfit.verba.verbaapi.domain.card.CardType
import java.time.OffsetDateTime

class PhotoCardDto(
    override var id: Long = 0,
    override var createe: OffsetDateTime? = null,
    override var repetition: OffsetDateTime? = null,
    override var type: CardType? = null,
    override var word: WordDto? = null,
    var photoResource: PhotoResourceDto? = null
) : CardDto(id, createe, repetition, type, word)