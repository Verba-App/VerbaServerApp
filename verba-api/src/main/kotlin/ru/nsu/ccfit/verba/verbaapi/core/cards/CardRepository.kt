package ru.nsu.ccfit.verba.verbaapi.core.cards

import org.springframework.data.jpa.repository.JpaRepository
import ru.nsu.ccfit.verba.verbaapi.domain.card.Card

interface CardRepository : JpaRepository<Card, Long> {
    fun findAllByCatalogId(catalogId: Long): List<Card>
}