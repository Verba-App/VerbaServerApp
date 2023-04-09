package ru.nsu.ccfit.verba.verbaapi.entity.resource

import jakarta.persistence.*
import ru.nsu.ccfit.verba.verbaapi.entity.User

enum class ResourceType {
    FILE,
    QOUTE
}


@Entity
@Table(name = "resources")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0

    open lateinit var name: String

    @Enumerated(EnumType.STRING)
    open lateinit var type: ResourceType

    @ManyToOne
    open lateinit var author: User
}