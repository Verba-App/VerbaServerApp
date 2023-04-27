package ru.nsu.ccfit.verba.verbaapi.core.cards

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.nsu.ccfit.verba.verbaapi.domain.card.Card

interface CardRepository : JpaRepository<Card, Long> {
    fun findAllByCatalogId(catalogId: Long): List<Card>
}