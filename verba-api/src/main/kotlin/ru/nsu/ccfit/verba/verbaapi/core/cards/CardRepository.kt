package ru.nsu.ccfit.verba.verbaapi.core.cards

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import ru.nsu.ccfit.verba.verbaapi.domain.card.Card

interface CardRepository : JpaRepository<Card, Long> {
    fun findAllByCatalogId(catalogId: Long): List<Card>

    @Transactional
    @Modifying
    @Query(value = "CALL next_step_card(:cardId, :userId)", nativeQuery = true)
    fun nextStepCard(@Param("userId") userId: Long, @Param("cardId") cardId: Long): Int

    @Transactional
    @Modifying
    @Query(value = "CALL repeat_card(:cardId, :userId)", nativeQuery = true)
    fun repeatCard(userId: Long, cardId: Long): Int
}
