package ru.nsu.ccfit.verba.verbaapi.domain.card

import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.nsu.ccfit.verba.verbaapi.domain.Catalog
import ru.nsu.ccfit.verba.verbaapi.domain.resource.PhotoResource
import ru.nsu.ccfit.verba.verbaapi.domain.Word
import java.sql.Date

@Entity
@Table(name = "photo_card")
class PhotoCard(
    override var id: Long,
    @ManyToOne
    override var catalog: Catalog,
    override var type: CardType,
    override var create: Date,
    override var repetition: Date,
    @ManyToOne
    override var word: Word,
    @ManyToOne
    var photoResource: PhotoResource
) : Card()