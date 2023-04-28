package ru.nsu.ccfit.verba.verbaapi.domain.resource

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import ru.nsu.ccfit.verba.verbaapi.domain.User


@Entity
@Table(name = "photo_resources")
class PhotoResource(
    id: Long,
    name: String,
    type: ResourceType,
    author: User,
    @Column
    private val path: String,

    ) : Resources(id, name, type, author)