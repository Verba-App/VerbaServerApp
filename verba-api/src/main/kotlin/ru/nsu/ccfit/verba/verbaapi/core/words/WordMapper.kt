package ru.nsu.ccfit.verba.verbaapi.core.words

import org.mapstruct.*
import ru.nsu.ccfit.verba.verbaapi.core.category.CategoryMapper
import ru.nsu.ccfit.verba.verbaapi.domain.Word

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = [CategoryMapper::class])
abstract class WordMapper {

    abstract fun toEntity(wordDto: WordDto): Word

    abstract fun toDto(word: Word): WordDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(wordDto: WordDto, @MappingTarget word: Word): Word
}