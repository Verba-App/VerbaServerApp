package ru.nsu.ccfit.verba.verbaapi.db


class PhotoResource (
    override var id: Long,
    override var name: String,
    override var type: ResourceType,
    override var author: User,

    private val path: String,

):Resources()