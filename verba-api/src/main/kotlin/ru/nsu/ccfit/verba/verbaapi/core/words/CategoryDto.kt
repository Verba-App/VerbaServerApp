package ru.nsu.ccfit.verba.verbaapi.core.words

import java.io.Serializable

/**
 * A DTO for the {@link ru.nsu.ccfit.verba.verbaapi.domain.Category} entity
 */
data class CategoryDto(val id: Long? = null, val name: String? = null) : Serializable