package ru.nsu.ccfit.verba.verbaapi.domain

import jakarta.persistence.*

@Entity
@Table(name = "verba_user")
class User(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,

    var name: String,

    var email: String,

    var region: String,

    var password: String
)

