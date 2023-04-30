package ru.nsu.ccfit.verba.verbaapi.core.users

import org.mapstruct.*
import ru.nsu.ccfit.verba.verbaapi.domain.User

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
abstract class UserMapper {

    abstract fun toEntity(userDto: UserDto): User

    abstract fun toDto(user: User): UserDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(userDto: UserDto, @MappingTarget user: User): User
}