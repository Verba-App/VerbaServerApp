package ru.nsu.ccfit.verba.verbaapi.core.cards

import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.nsu.ccfit.verba.verbaapi.core.words.WordMapper
import ru.nsu.ccfit.verba.verbaapi.domain.card.Card

@Component
class CardMapper {

    @Autowired
    private val wordMapper: WordMapper? = null

    fun toDto(card: Card): CardDto {

        val cardDto = CardDto()
        cardDto.id = card.id
        cardDto.create = card.create
        cardDto.repetition = card.repetition
        cardDto.type = card.type
        cardDto.word = wordMapper!!.toDto(card.word)
        return cardDto
    }
}