package ru.nsu.ccfit.verba.verbaapi.domain.card

import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.nsu.ccfit.verba.verbaapi.domain.Catalog
import ru.nsu.ccfit.verba.verbaapi.domain.resource.QuoteResource
import ru.nsu.ccfit.verba.verbaapi.domain.Word
import java.sql.Date
import java.time.OffsetDateTime

@Entity
@Table(name = "quote_card")
class QuoteCard(
    override var id: Long,
    @ManyToOne
    override var catalog: Catalog,
    override var type: CardType,
    override var create: OffsetDateTime,
    override var repetition: OffsetDateTime,
    @ManyToOne
    override var word: Word,
    @ManyToOne
    var quoteResource: QuoteResource
) : Card()