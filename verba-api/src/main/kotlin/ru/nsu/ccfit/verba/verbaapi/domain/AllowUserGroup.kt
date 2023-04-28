package ru.nsu.ccfit.verba.verbaapi.domain

import jakarta.persistence.*

@Entity
@Table(name = "allow_user_group")
class AllowUserGroup(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long,

    @ManyToOne
    val user: User,

    @ManyToOne
    val group: GroupCatalog,

    val accessRead: Boolean,

    val accessChanges: Boolean,

    @ManyToOne
    val tactic: Tactics
)