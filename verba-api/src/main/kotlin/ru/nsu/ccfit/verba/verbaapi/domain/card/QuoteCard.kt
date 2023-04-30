package ru.nsu.ccfit.verba.verbaapi.domain.card

import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.nsu.ccfit.verba.verbaapi.domain.Catalog
import ru.nsu.ccfit.verba.verbaapi.domain.resource.QuoteResource
import ru.nsu.ccfit.verba.verbaapi.domain.Word
import java.time.OffsetDateTime


@Entity
@Table(name = "quote_card")
class QuoteCard(
    id: Long,
    catalog: Catalog,
    type: CardType,
    create: OffsetDateTime,
    word: Word,
    @ManyToOne
    var quoteResource: QuoteResource
) : Card(id, create, type ,catalog, word)