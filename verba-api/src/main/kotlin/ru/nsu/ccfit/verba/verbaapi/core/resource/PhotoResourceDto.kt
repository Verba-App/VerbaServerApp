package ru.nsu.ccfit.verba.verbaapi.core.resource

import ru.nsu.ccfit.verba.verbaapi.domain.resource.ResourceType
import java.io.Serializable

data class PhotoResourceDto(
    var id: Long?,
    var name: String?,
    var type: ResourceType?,
    var path: String?
) : Serializable