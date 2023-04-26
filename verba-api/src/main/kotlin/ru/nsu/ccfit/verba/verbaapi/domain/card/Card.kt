package ru.nsu.ccfit.verba.verbaapi.domain.card

import jakarta.persistence.*
import ru.nsu.ccfit.verba.verbaapi.domain.Catalog
import ru.nsu.ccfit.verba.verbaapi.domain.Word
import java.sql.Date
import java.time.OffsetDateTime


enum class CardType {
    PHOTO,
    QUOTE
}


@Entity
@Table(name = "card")
@Inheritance(strategy = InheritanceType.JOINED)
open class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0

    open lateinit var create: OffsetDateTime
    open lateinit var repetition: OffsetDateTime

    @ManyToOne
    open lateinit var catalog: Catalog

    @Enumerated(EnumType.STRING)
    open lateinit var type: CardType

    @ManyToOne
    open lateinit var word: Word
}