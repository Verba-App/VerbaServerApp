package ru.nsu.ccfit.verba.verbaapi.core.cards.types.photo

import org.mapstruct.*
import ru.nsu.ccfit.verba.verbaapi.core.words.WordMapper
import ru.nsu.ccfit.verba.verbaapi.domain.card.PhotoCard
import ru.nsu.ccfit.verba.verbaapi.core.resource.PhotoResourceMapper

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = "spring",
    uses = [PhotoResourceMapper::class, WordMapper::class]
)
abstract class PhotoCardMapper {

    abstract fun toEntity(photoCardDto: PhotoCardDto): PhotoCard

    abstract fun toDto(photoCard: PhotoCard): PhotoCardDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(photoCardDto1: PhotoCardDto, @MappingTarget photoCard: PhotoCard): PhotoCard
}