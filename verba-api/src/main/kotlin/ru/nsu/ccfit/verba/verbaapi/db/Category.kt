package ru.nsu.ccfit.verba.verbaapi.db

import jakarta.persistence.*

@Entity
@Table(name = "category")
class Category(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private var id: Long,
    private val name: String
)