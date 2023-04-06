package ru.nsu.ccfit.verba.verbaapi.db

import jakarta.persistence.*
import java.sql.Date
import java.sql.Timestamp

@Entity
@Table(name = "card")
class Card(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private var id: Long,
    private val create: Date,

    private val repetition: Date,

    @ManyToOne
    private val catalog: Catalog,

    //TODO Было поставлено для эксперимента, нужно убрать
    @ManyToOne
    private val photoResource: Resources,

    @ManyToOne
    private val word: Word
)