package ru.nsu.ccfit.verba.verbaapi.domain

import jakarta.persistence.*
import java.sql.Date

@Entity
@Table(name = "catalog")
class Catalog(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,
    var name: String,
    var createDate: Date,
    @ManyToOne
    var author: User,
    @ManyToOne
    var group: GroupCatalog
)