package ru.nsu.ccfit.verba.verbaapi.core.resource

import org.mapstruct.*
import ru.nsu.ccfit.verba.verbaapi.domain.resource.PhotoResource

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class PhotoResourceMapper {

    abstract fun toEntity(photoResourceDto: PhotoResourceDto): PhotoResource

    abstract fun toDto(photoResource: PhotoResource): PhotoResourceDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(
        photoResourceDto: PhotoResourceDto,
        @MappingTarget photoResource: PhotoResource
    ): PhotoResource
}