package ru.nsu.ccfit.verba.verbaapi.core.cards

import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy
import ru.nsu.ccfit.verba.verbaapi.domain.StatusCard

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
interface StatusCardMapper {
    fun toDto(statusCard: StatusCard): StatusCardDto
}
