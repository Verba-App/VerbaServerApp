package ru.nsu.ccfit.verba.verbaapi.core.catalogs

import org.mapstruct.*
import ru.nsu.ccfit.verba.verbaapi.domain.Catalog

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class CatalogMapper {

    abstract fun toEntity(catalogDto: CatalogDto): Catalog

    abstract fun toDto(catalog: Catalog): CatalogDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(catalogDto: CatalogDto, @MappingTarget catalog: Catalog): Catalog
}