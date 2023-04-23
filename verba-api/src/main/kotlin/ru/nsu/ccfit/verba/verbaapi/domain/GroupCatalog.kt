package ru.nsu.ccfit.verba.verbaapi.domain

import jakarta.persistence.*

@Entity
@Table(name = "group_catalog")
class GroupCatalog(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,
    var name: String,
    @ManyToOne
    var author: User
)