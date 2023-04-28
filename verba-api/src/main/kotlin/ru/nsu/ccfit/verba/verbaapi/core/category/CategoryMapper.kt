package ru.nsu.ccfit.verba.verbaapi.core.category

import org.mapstruct.*
import ru.nsu.ccfit.verba.verbaapi.domain.Category

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class CategoryMapper {

    abstract fun toEntity(categoryDto: CategoryDto): Category

    abstract fun toDto(category: Category): CategoryDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(categoryDto: CategoryDto, @MappingTarget category: Category): Category
}