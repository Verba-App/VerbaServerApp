package ru.nsu.ccfit.verba.verbaapi.db

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "group_catalog")
class GroupCatalog(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private var id: Long,
    private val name: String,
    @ManyToOne
    private val author: User
)