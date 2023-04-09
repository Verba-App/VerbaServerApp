package ru.nsu.ccfit.verba.verbaapi.entity.resource

import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import ru.nsu.ccfit.verba.verbaapi.entity.User


@Entity
@Table(name = "quote_resources")
class QuoteResource (
    override var id: Long,
    override var name: String,
    override var type: ResourceType,
    @ManyToOne
    override var author: User,
    private val context: String,
    ): Resources()