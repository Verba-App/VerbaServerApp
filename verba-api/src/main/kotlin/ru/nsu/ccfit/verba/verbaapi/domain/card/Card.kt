package ru.nsu.ccfit.verba.verbaapi.domain.card

import jakarta.persistence.*
import ru.nsu.ccfit.verba.verbaapi.domain.Catalog
import ru.nsu.ccfit.verba.verbaapi.domain.Word
import java.time.OffsetDateTime


enum class CardType {
    PHOTO,
    QUOTE
}


@Entity
@Table(name = "card")
@Inheritance(strategy = InheritanceType.JOINED)
open class Card(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0,

    @Column(name = "create_date")
    open var createDate: OffsetDateTime,

    @Enumerated(EnumType.STRING)
    open var type: CardType,

    @ManyToOne
    open var catalog: Catalog,

    @ManyToOne
    open var word: Word
)

