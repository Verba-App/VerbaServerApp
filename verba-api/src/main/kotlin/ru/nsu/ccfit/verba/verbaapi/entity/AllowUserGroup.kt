package ru.nsu.ccfit.verba.verbaapi.entity

import jakarta.persistence.*

@Entity
@Table(name = "allow_user_group")
class AllowUserGroup(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private var id: Long,

    @ManyToOne
    private val user: User,

    @ManyToOne
    private val group: GroupCatalog,

    private val accessRead: Boolean,

    private val accessChanges: Boolean,

    @ManyToOne
    private val tactic: Tactics
)