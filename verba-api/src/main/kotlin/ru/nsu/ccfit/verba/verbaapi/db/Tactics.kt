package ru.nsu.ccfit.verba.verbaapi.db

import jakarta.persistence.*

@Entity
@Table(name = "tactics")
class Tactics(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private var id: Long,
    private val name: String,
    @ManyToOne
    private val author: User
)