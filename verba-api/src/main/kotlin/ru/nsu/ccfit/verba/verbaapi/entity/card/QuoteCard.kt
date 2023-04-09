package ru.nsu.ccfit.verba.verbaapi.entity.card

import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.nsu.ccfit.verba.verbaapi.entity.Catalog
import ru.nsu.ccfit.verba.verbaapi.entity.resource.QuoteResource
import ru.nsu.ccfit.verba.verbaapi.entity.Word
import java.sql.Date

@Entity
@Table(name = "quote_card")
class QuoteCard(
    override var id: Long,
    @ManyToOne
    override var catalog: Catalog,
    override var type: CardType,
    override var create: Date,
    override var repetition: Date,
    @ManyToOne
    override var word: Word,
    @ManyToOne
    var quoteResource: QuoteResource
) : Card()