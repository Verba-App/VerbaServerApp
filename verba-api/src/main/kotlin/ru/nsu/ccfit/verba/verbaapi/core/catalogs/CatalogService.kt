package ru.nsu.ccfit.verba.verbaapi.core.catalogs

import org.springframework.stereotype.Service
import ru.nsu.ccfit.verba.verbaapi.core.groups.GroupDto


@Service
class CatalogService {
    fun getById(id: Long): CatalogDto {
        TODO("Not yet implemented")
    }

    fun add(catalogDto: CatalogDto) {
        TODO("Not yet implemented")
    }

    fun getAllCatalogByGroup(groupId: Long): List<GroupDto> {
        TODO("Not yet implemented")
    }
}