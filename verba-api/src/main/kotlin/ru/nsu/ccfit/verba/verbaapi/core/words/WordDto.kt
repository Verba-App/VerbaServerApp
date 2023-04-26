package ru.nsu.ccfit.verba.verbaapi.core.words

import ru.nsu.ccfit.verba.verbaapi.domain.WordType
import java.io.Serializable

/**
 * A DTO for the {@link ru.nsu.ccfit.verba.verbaapi.domain.Word} entity
 */
data class WordDto(
    val id: Long? = null,
    val word: String? = null,
    val transcription: String? = null,
    val type: WordType? = null,
    val categories: List<CategoryDto?>
) : Serializable