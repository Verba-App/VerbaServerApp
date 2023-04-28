package ru.nsu.ccfit.verba.verbaapi.core.cards

import org.springframework.stereotype.Service
import ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo.PhotoCardDto
import ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo.PhotoCardMapper
import ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo.PhotoCardRepository
import ru.nsu.ccfit.verba.verbaapi.platform.exception.NotFoundException


@Service
class CardService(
    private val cardRepository: CardRepository,
    private val photoCardMapper: PhotoCardMapper,
    private val photoCardRepository: PhotoCardRepository,
    private val mapper: CardMapper
) {


    fun getAllCardByCatalog(catalogId: Long): List<CardDto> {
        return cardRepository.findAllByCatalogId(catalogId).map { mapper.toDto(it) }
    }

    fun getCardById(id: Long): CardDto {
        return cardRepository.findById(id).orElseThrow { NotFoundException("Карточка с id $id не найдена") }.run { mapper.toDto(this) }
    }

    fun getPhotoCardById(id: Long): PhotoCardDto {
        return photoCardRepository.findById(id)
            .orElseThrow { NotFoundException("Карточка с типом PHOTO с id $id не найдена!") }
            .run { photoCardMapper.toDto(this) }
    }

}