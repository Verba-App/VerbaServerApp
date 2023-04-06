package ru.nsu.ccfit.verba.verbaapi.db

import jakarta.persistence.*
import java.sql.Date

@Entity
@Table(name = "user")
class User(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,

    var name: String,

    var email: String,

    var birthday: Date,

    var region: String,

    var password: String
)

