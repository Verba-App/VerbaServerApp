package ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo

import org.springframework.data.jpa.repository.JpaRepository
import ru.nsu.ccfit.verba.verbaapi.domain.card.PhotoCard

interface PhotoCardRepository : JpaRepository<PhotoCard, Long> {
}