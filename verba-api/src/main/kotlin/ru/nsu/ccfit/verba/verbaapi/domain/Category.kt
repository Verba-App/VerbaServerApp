package ru.nsu.ccfit.verba.verbaapi.domain

import jakarta.persistence.*

@Entity
@Table(name = "category")
class Category(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,
    val name: String
)