package ru.nsu.ccfit.verba.verbaapi.core.words

import ru.nsu.ccfit.verba.verbaapi.domain.WordType
import java.io.Serializable

/**
 * A DTO for the {@link ru.nsu.ccfit.verba.verbaapi.domain.Word} entity
 */
data class WordDto(
    var id: Long? = null,
    var word: String? = null,
    var transcription: String? = null,
    var type: WordType? = null,
    var categories: List<CategoryDto?>
) : Serializable