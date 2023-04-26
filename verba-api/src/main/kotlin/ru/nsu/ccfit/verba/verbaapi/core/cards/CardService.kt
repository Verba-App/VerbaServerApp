package ru.nsu.ccfit.verba.verbaapi.core.cards

import org.springframework.stereotype.Service


@Service
class CardService(
    private val cardRepository: CardRepository,
    private val mapper: CardMapper
) {


    fun getAllCardByCatalog(catalogId :Long): List<CardDto> {
       return cardRepository.findAllByCatalogId(catalogId).map { mapper.toDto(it) }
    }

}