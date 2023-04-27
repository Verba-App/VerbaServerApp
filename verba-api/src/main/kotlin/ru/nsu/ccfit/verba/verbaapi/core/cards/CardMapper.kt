package ru.nsu.ccfit.verba.verbaapi.core.cards

import org.mapstruct.*
import ru.nsu.ccfit.verba.verbaapi.core.words.WordMapper
import ru.nsu.ccfit.verba.verbaapi.domain.card.Card

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = [WordMapper::class])
abstract class CardMapper {

    abstract fun toEntity(cardDto: CardDto): Card

    abstract fun toDto(card: Card): CardDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(cardDto: CardDto, @MappingTarget card: Card): Card
}