package ru.nsu.ccfit.verba.verbaapi.core.cards

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo.PhotoCardDto
import ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo.PhotoCardMapper
import ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo.PhotoCardRepository
import ru.nsu.ccfit.verba.verbaapi.core.groups.AllowGroupRepository
import ru.nsu.ccfit.verba.verbaapi.platform.exception.NotFoundException

@Service
class CardService(
    private val cardRepository: CardRepository,
    private val allowGroupRepository: AllowGroupRepository,
    private val photoCardRepository: PhotoCardRepository,
    private val photoCardMapper: PhotoCardMapper,
    private val cardMapper: CardMapper,
    private val statusCardMapper: StatusCardMapper
) {


    fun getAllCardByCatalog(catalogId: Long): List<CardDto> {
        return cardRepository.findAllByCatalogId(catalogId).map { cardMapper.toDto(it) }
    }

    fun getCardById(id: Long): CardDto {
        return cardRepository.findById(id).orElseThrow { NotFoundException("Карточка с id $id не найдена") }
            .run { cardMapper.toDto(this) }
    }

    fun getPhotoCardById(id: Long): PhotoCardDto {
        return photoCardRepository.findById(id)
            .orElseThrow { NotFoundException("Карточка с типом PHOTO с id $id не найдена!") }
            .run { photoCardMapper.toDto(this) }
    }

    @Transactional
    fun renewalCardByUserId(userId: Long, cardId: Long) {
        cardRepository.repeatCard(userId, cardId)
    }

    @Transactional
    fun studiedCardByUserId(userId: Long, cardId: Long) {
        cardRepository.nextStepCard(userId, cardId)
        cardRepository.repeatCard(userId, cardId)
    }

    fun getStatusCardById(userId: Long, cardId: Long): StatusCardDto {
        val allowGroup = allowGroupRepository.getAllowUserGroupByUserIdAndCardId(userId, cardId)
        val statusCard = allowGroup.statusCards;
        if (!statusCard.containsKey(cardId)) {
            throw NotFoundException("Карта с id=$cardId не найдена")
        }
        return statusCardMapper.toDto(statusCard[cardId]!!)
    }

    fun createPhotoCard(photoCardDto: PhotoCardDto) {
        photoCardRepository.save(photoCardMapper.toEntity(photoCardDto))
    }

}