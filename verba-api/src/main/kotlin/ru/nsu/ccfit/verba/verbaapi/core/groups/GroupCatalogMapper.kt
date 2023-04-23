package ru.nsu.ccfit.verba.verbaapi.core.groups

import org.mapstruct.*
import ru.nsu.ccfit.verba.verbaapi.domain.GroupCatalog
import ru.nsu.ccfit.verba.verbaapi.core.users.UserMapper

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
    uses = [UserMapper::class]
)
interface GroupCatalogMapper {

     fun toEntity(groupDto: GroupDto): GroupCatalog

     fun toDto(groupCatalog: GroupCatalog): GroupDto
}