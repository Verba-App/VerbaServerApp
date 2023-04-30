package ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo

import ru.nsu.ccfit.verba.verbaapi.core.cards.CardDto
import ru.nsu.ccfit.verba.verbaapi.core.resource.PhotoResourceDto
import ru.nsu.ccfit.verba.verbaapi.core.words.WordDto
import ru.nsu.ccfit.verba.verbaapi.domain.card.CardType
import java.time.OffsetDateTime

class PhotoCardDto(
    override var id: Long = 0,
    override var createDate: OffsetDateTime?,
    override var type: CardType?,
    override var word: WordDto?,
    var photoResource: PhotoResourceDto?
) : CardDto(id, createDate, type, word)