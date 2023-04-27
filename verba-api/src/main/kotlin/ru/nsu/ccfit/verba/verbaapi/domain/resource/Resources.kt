package ru.nsu.ccfit.verba.verbaapi.domain.resource

import jakarta.persistence.*
import ru.nsu.ccfit.verba.verbaapi.domain.User

enum class ResourceType {
    PHOTO,
    QUOTE
}


@Entity
@Table(name = "resources")
@Inheritance(strategy = InheritanceType.JOINED)
open class Resources(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0,

    open var name: String,

    @Enumerated(EnumType.STRING)
    open var type: ResourceType,

    @ManyToOne
    open var author: User
)