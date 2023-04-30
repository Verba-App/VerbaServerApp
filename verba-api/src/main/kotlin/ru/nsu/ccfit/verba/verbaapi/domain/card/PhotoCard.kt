package ru.nsu.ccfit.verba.verbaapi.domain.card

import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.nsu.ccfit.verba.verbaapi.domain.Catalog
import ru.nsu.ccfit.verba.verbaapi.domain.resource.PhotoResource
import ru.nsu.ccfit.verba.verbaapi.domain.Word
import java.time.OffsetDateTime

@Entity
@Table(name = "photo_card")
class PhotoCard(
    id: Long,
    catalog: Catalog,
    type: CardType,
    create: OffsetDateTime,
    word: Word,
    @ManyToOne
    var photoResource: PhotoResource
) : Card(id, create,type, catalog, word)