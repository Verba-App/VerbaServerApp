package ru.nsu.ccfit.verba.verbaapi.core.words

import ru.nsu.ccfit.verba.verbaapi.core.category.CategoryDto
import ru.nsu.ccfit.verba.verbaapi.domain.WordType
import java.io.Serializable

data class WordDto(
    var id: Long? ,
    var text: String? ,
    var transcription: String? ,
    var type: WordType?,
    var categories: Set<CategoryDto?>
) : Serializable